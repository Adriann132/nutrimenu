package com.practicas.nutrimenu.controller;

import com.practicas.nutrimenu.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Importante: Controller, no RestController
import org.springframework.ui.Model; // El Model para pasar datos a la web
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @GetMapping("/ver-usuarios")
    public String usuariosPagina(Model model) {
        // Buscamos los usuarios y los guardamos en una variable llamada "usuarios"
        // que el archivo HTML podrá leer
        model.addAttribute("usuarios", usuarioRepo.findAll());

        // Retornamos el nombre del archivo HTML (sin el .html)
        return "usuarios";
    }
}