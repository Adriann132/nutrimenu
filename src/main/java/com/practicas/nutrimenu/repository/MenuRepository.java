package com.practicas.nutrimenu.repository;

import com.practicas.nutrimenu.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    // Buscamos menús por el ID del usuario
    List<Menu> findByUsuarioId(Long usuarioId);
}