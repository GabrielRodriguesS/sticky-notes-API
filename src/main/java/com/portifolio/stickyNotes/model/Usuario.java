package com.portifolio.stickyNotes.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<Notas> notas;

}
