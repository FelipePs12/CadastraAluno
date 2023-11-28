package com.example.TrabalhoFelipeJava.service;


import com.example.TrabalhoFelipeJava.model.Aluno;
import com.example.TrabalhoFelipeJava.repository.AlunoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoSer {
    @Autowired
    private AlunoRep alunoRep;

    public List<Aluno> listarAlunos() {
        return alunoRep.findAll();
    }

    public Optional<Aluno> obterAlunoPorId(Long id) {
        return alunoRep.findById(id);
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRep.save(aluno);
    }

    public void excluirAluno(Long id) {
        alunoRep.deleteById(id);
    }
}

