package com.portifolio.stickyNotes.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "corpo")
    private String corpo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToMany(cascade = {CascadeType.DETACH})
    @JoinTable(
            name = "notas_categoria",
            joinColumns = {@JoinColumn(name = "id_notas")},
            inverseJoinColumns = {@JoinColumn(name = "id_categoria")}
    )
    private Set<Categoria> categorias = new HashSet<>();

}
