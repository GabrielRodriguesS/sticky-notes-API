package com.portifolio.stickyNotes.repository;
import com.portifolio.stickyNotes.model.Notas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasRepository extends JpaRepository<Notas, Integer> {

    long countByUsuario_Id(Integer id);

    Page<Notas> findByUsuario_Id(Pageable paginacao, Integer id);

}

