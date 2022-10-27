package com.portifolio.stickyNotes.controller;

import com.portifolio.stickyNotes.model.Usuario;
import com.portifolio.stickyNotes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("obter_todos")
    public List<Usuario> obterTodosUsuarios() {
        return this.repository.findAll();
    }
}
