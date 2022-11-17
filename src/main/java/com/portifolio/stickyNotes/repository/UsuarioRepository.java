package com.portifolio.stickyNotes.repository;

import com.portifolio.stickyNotes.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Page<Usuario> findById(Pageable paginacao, Integer id);


}
