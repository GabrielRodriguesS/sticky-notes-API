package com.portifolio.stickyNotes.controller;
import com.portifolio.stickyNotes.model.Notas;
import com.portifolio.stickyNotes.repository.NotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("notas")
public class NotasController {

    @Autowired
    private NotasRepository repository;

    @GetMapping("obter_notas")
    public List<Notas> obterTodasAsNotas() {

        return this.repository.findAll();
    }

}
