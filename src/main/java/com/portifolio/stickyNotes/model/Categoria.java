package com.portifolio.stickyNotes.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private Set<Notas> notas = new HashSet<>();


}
