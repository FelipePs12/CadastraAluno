package com.example.TrabalhoFelipeJava.controller;

import com.example.TrabalhoFelipeJava.model.Disciplina;
import com.example.TrabalhoFelipeJava.service.DisciplinaSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaCtl {
    @Autowired
    private DisciplinaSer disService;

    @GetMapping
    public List<Disciplina> listarDisciplinas() {
        return disService.listarDisciplinas();
    }

    @GetMapping("/{id}")
    public Optional<Disciplina> obterDisciplina(@PathVariable Long id) {
        return disService.obterDisciplinaPorId(id);
    }

    @PostMapping
    public Disciplina cadastrarDisciplina(@RequestBody Disciplina disciplina) {
        return disService.cadastrarDisciplina(disciplina);
    }

    @DeleteMapping("/{id}")
    public void excluirDisciplina(@PathVariable Long id) {
        disService.excluirDisciplina(id);
    }
}