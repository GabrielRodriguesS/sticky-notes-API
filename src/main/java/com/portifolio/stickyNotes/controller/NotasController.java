package com.portifolio.stickyNotes.controller;
import com.portifolio.stickyNotes.model.Notas;
import com.portifolio.stickyNotes.repository.NotasRepository;
import com.portifolio.stickyNotes.repository.UsuarioRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("notas")
public class NotasController {

    @Autowired
    private NotasRepository repository;
    private UsuarioRepository notasRepository;


    @GetMapping("obter_notas/{id}")
    public Page<Notas> obterTodasAsNotas(Pageable paginacao, @PathVariable("id") Integer id) {
        return this.repository.findByUsuario_Id(paginacao, id);

    }

    @SneakyThrows
    @PostMapping("salvar/{id}")
    public Notas salvarNotas(@PathVariable("id") Integer id) {
        Optional<Notas> notasOptional = this.repository.findById(id);
        return notasOptional.map(notas -> {
            notas.setId(id);
            return this.repository.save(notas);
        }).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }


    @DeleteMapping("/deletar/{id}")
    public Map<String, Boolean> deletar(@PathVariable(value = "id") Integer id)
            throws ChangeSetPersister.NotFoundException {
        Notas notas = repository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        repository.delete(notas);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PatchMapping("/editar/{id}/{titulo}")
    public Notas updateCategoriaPartially(@PathVariable Integer id, @PathVariable String titulo)
            throws ChangeSetPersister.NotFoundException {
        Notas notas = repository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        notas.setTitulo(titulo);
        return repository.save(notas);
    }

    @PutMapping(value = "/alterarCampos/{id}")
    public ResponseEntity<Notas> updateNotas(@PathVariable Integer id, @RequestBody Notas notas)
            throws ChangeSetPersister.NotFoundException {
        Notas updateNotas = repository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        updateNotas.setTitulo(notas.getTitulo());
        updateNotas.setCorpo(notas.getCorpo());

        repository.save(updateNotas);

        return ResponseEntity.ok(updateNotas);


    }

}