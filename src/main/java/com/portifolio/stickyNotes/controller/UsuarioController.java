package com.portifolio.stickyNotes.controller;
import com.portifolio.stickyNotes.model.Notas;
import com.portifolio.stickyNotes.model.Usuario;
import com.portifolio.stickyNotes.repository.NotasRepository;
import com.portifolio.stickyNotes.repository.UsuarioRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.io.Serial;
import java.util.*;

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

    @GetMapping("obter_todos/{id}")
    public Page<Usuario> obterTodosUsuarios(Pageable paginacao, @PathVariable("id") Integer id) {
        return this.repository.findById(paginacao, id);
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

    @PatchMapping("/editar/{id}/{nome}")
    public Usuario updateUsuarioPartially(@PathVariable Integer id, @PathVariable String nome) throws ChangeSetPersister.NotFoundException {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        usuario.setNome(nome);
        return repository.save(usuario);
    }

    @DeleteMapping("/deletar/{id}")
    public Map<String, Boolean> deletar(@PathVariable(value = "id") Integer id)
            throws ChangeSetPersister.NotFoundException {
        Usuario usuario = (Usuario) repository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        repository.delete(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}



