package com.example.TrabalhoFelipeJava.controller;


import com.example.TrabalhoFelipeJava.model.Curso;
import com.example.TrabalhoFelipeJava.service.CursoSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoCtl {
    @Autowired
    private CursoSer curService;

    @GetMapping
    public List<Curso> listarCursos() {
        return curService.listarCursos();
    }

    @GetMapping("/{id}")
    public Optional<Curso> obterCurso(@PathVariable Long id) {
        return curService.obterCursoPorId(id);
    }

    @PostMapping
    public Curso cadastrarCurso(@RequestBody Curso curso) {
        return curService.cadastrarCurso(curso);
    }

    @DeleteMapping("/{id}")
    public void excluirCurso(@PathVariable Long id) {
        curService.excluirCurso(id);
    }
}