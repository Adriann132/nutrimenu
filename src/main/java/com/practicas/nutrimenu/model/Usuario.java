package com.practicas.nutrimenu.model;

import jakarta.persistence.*;
import java.util.List;

@Entity // Esto le dice a Spring que esta clase es una tabla de BD
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación: Un usuario tiene muchos menús.
    // mappedBy indica que la relación se gestiona en la clase Menu
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Menu> menus;

    // Constructores
    public Usuario() {}

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Menu> getMenus() { return menus; }
    public void setMenus(List<Menu> menus) { this.menus = menus; }
}