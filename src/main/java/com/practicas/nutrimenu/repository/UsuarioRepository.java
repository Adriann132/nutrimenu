package com.practicas.nutrimenu.repository;

import com.practicas.nutrimenu.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Esto ya incluye métodos como save(), findById(), delete()...
}