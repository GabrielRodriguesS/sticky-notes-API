package com.portifolio.stickyNotes.controller;


import com.portifolio.stickyNotes.model.Categoria;
import com.portifolio.stickyNotes.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

        @Autowired
        private CategoriaRepository repository;

        @GetMapping("obter_categoria")
        public List<Categoria> obterTodas() {
                return this.repository.findAll();
        }
}
