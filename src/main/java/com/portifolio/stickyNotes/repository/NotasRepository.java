package com.portifolio.stickyNotes.repository;
import com.portifolio.stickyNotes.model.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasRepository extends JpaRepository<Notas, Integer> {

    long countByUsuario_Id(Integer id);
}

