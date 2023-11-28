package com.example.TrabalhoFelipeJava.service;


import com.example.TrabalhoFelipeJava.model.Disciplina;
import com.example.TrabalhoFelipeJava.repository.DisciplinaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DisciplinaSer {
    @Autowired
    private DisciplinaRep disciplinaRep;

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRep.findAll();
    }

    public Optional<Disciplina> obterDisciplinaPorId(Long id) {
        return disciplinaRep.findById(id);
    }

    public Disciplina cadastrarDisciplina(Disciplina disciplina) {
        return disciplinaRep.save(disciplina);
    }

    public void excluirDisciplina(Long id) {
        disciplinaRep.deleteById(id);
    }
}