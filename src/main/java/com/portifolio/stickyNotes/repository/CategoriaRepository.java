package com.portifolio.stickyNotes.repository;
import com.portifolio.stickyNotes.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Page<Categoria> findByUsuario_Id(Pageable pageable, Integer usuario_id);
}

