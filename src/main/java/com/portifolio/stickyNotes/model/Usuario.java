package com.portifolio.stickyNotes.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode


public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Notas> notas;
}
