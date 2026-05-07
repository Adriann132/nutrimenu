package com.practicas.nutrimenu.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String desayuno;
    private String comida;
    private String cena;
    private LocalDate fecha;

    // Muchos menús pertenecen a un usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Constructores
    public Menu() {}

    public Menu(String desayuno, String comida, String cena, LocalDate fecha, Usuario usuario) {
        this.desayuno = desayuno;
        this.comida = comida;
        this.cena = cena;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDesayuno() { return desayuno; }
    public void setDesayuno(String desayuno) { this.desayuno = desayuno; }
    public String getComida() { return comida; }
    public void setComida(String comida) { this.comida = comida; }
    public String getCena() { return cena; }
    public void setCena(String cena) { this.cena = cena; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}