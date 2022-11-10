package com.portifolio.stickyNotes.controller;
import com.portifolio.stickyNotes.model.Categoria;
import com.portifolio.stickyNotes.model.Notas;
import com.portifolio.stickyNotes.model.Usuario;
import com.portifolio.stickyNotes.repository.CategoriaRepository;
import com.portifolio.stickyNotes.repository.UsuarioRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("categoria")

public class CategoriaController {

        @Autowired
        private CategoriaRepository repository;

        @Autowired
        private UsuarioRepository usuarioRepository;

        @GetMapping("obter_categoria/{id}")
        public Page<Categoria> obterTodasCategorias(Pageable paginacao, @PathVariable("id") Integer id) {
                return this.repository.findByUsuario_Id(paginacao, id);
        }

        @SneakyThrows
        @PostMapping("salvar/{usuarioId}")
        public Categoria salvarCategoria(@RequestBody Categoria categoria, @PathVariable("usuarioId") Integer usuarioId) {
//                Usuario usuario = this.usuarioRepository.findById(usuarioId).get();
//                if (usuario != null) {
//                        categoria.setUsuario(usuario);
//                        return this.repository.save(categoria);
//                } else {
//                        throw new ChangeSetPersister.NotFoundException();
//                }

                Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(usuarioId);
                return usuarioOptional.map(usuario -> {
                        categoria.setUsuario(usuario);
                        return this.repository.save(categoria);
                }).orElseThrow(ChangeSetPersister.NotFoundException::new);


        }

        @DeleteMapping("/deletar/{id}")
        public Map<String, Boolean> deletar(@PathVariable(value = "id") Integer categoria_id)
                throws ChangeSetPersister.NotFoundException {
                Categoria categoria = repository.findById(categoria_id)
                        .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
                repository.delete(categoria);
                Map<String, Boolean> response = new HashMap<>();
                response.put("deleted", Boolean.TRUE);
                return response;
        }

        @PatchMapping("/editar/{id}/{nome}")
        public Categoria updateCategoriaPartially(@PathVariable Integer id, @PathVariable String nome) throws ChangeSetPersister.NotFoundException {
                Categoria categoria = repository.findById(id)
                        .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
                categoria.setNome(nome);
                return repository.save(categoria);
        }

}
