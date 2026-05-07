package com.practicas.nutrimenu.controller;

import com.practicas.nutrimenu.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // IMPORTANTE: @Controller, NO @RestController
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Esta anotación es la que permite buscar el HTML
public class WebController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @GetMapping("/ver-usuarios")
    public String usuariosPagina(Model model) {
        model.addAttribute("usuarios", usuarioRepo.findAll());
        return "usuarios"; // Esto busca "templates/usuarios.html"
    }
}