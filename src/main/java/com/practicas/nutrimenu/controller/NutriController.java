package com.practicas.nutrimenu.controller;

import com.practicas.nutrimenu.model.Menu;
import com.practicas.nutrimenu.model.Usuario;
import com.practicas.nutrimenu.repository.MenuRepository;
import com.practicas.nutrimenu.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NutriController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private MenuRepository menuRepo;

    // 1. Crear un usuario (Ej: POST http://localhost:8080/api/usuarios)
    @PostMapping("/usuarios")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    // Nuevo método para listar todos los usuarios
    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    // 2. Registrar un menú a un usuario (Ej: POST http://localhost:8080/api/1/menu)
    @PostMapping("/{usuarioId}/menu")
    public Menu registrarMenu(@PathVariable Long usuarioId, @RequestBody Menu menu) {
        return usuarioRepo.findById(usuarioId).map(u -> {
            menu.setUsuario(u);
            menu.setFecha(LocalDate.now());
            return menuRepo.save(menu);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // 3. Ver menús de un usuario (Ej: GET http://localhost:8080/api/1/menus)
    @GetMapping("/{usuarioId}/menus")
    public List<Menu> verMenus(@PathVariable Long usuarioId) {
        return menuRepo.findByUsuarioId(usuarioId);
    }
}