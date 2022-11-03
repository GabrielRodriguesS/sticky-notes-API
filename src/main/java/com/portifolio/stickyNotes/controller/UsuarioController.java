package com.portifolio.stickyNotes.controller;

import com.portifolio.stickyNotes.model.Notas;
import com.portifolio.stickyNotes.model.Usuario;
import com.portifolio.stickyNotes.repository.NotasRepository;
import com.portifolio.stickyNotes.repository.UsuarioRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private NotasRepository notasRepository;

    @GetMapping("conta_notas/{id}")
    public long contaAsNotasDoUsuario(@PathVariable("id") Integer id) {
        return this.notasRepository.countByUsuario_Id(id);
    }

    @GetMapping("obter_todos")
    public List<Usuario> obterTodosUsuarios() {
        return this.repository.findAll();
    }

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario novoUsuario) {
        return this.repository.save(novoUsuario);
    }

    @SneakyThrows
    @PostMapping("nota/{usuarioId}")
    public Notas salvarUsuario(@RequestBody Notas nota, @PathVariable("usuarioId") Integer usuarioId) {
        Optional<Usuario> usuarioOptional = this.repository.findById(usuarioId);
        return usuarioOptional.map(usuario -> {
            nota.setUsuario(usuario);
            return this.notasRepository.save(nota);
        }).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
