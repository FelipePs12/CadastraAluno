package com.example.TrabalhoFelipeJava.service;


import com.example.TrabalhoFelipeJava.model.Curso;
import com.example.TrabalhoFelipeJava.repository.CursoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoSer {
    @Autowired
    private CursoRep cursoRep;

    public List<Curso> listarCursos() {
        return cursoRep.findAll();
    }

    public Optional<Curso> obterCursoPorId(Long id) {
        return cursoRep.findById(id);
    }

    public Curso cadastrarCurso(Curso curso) {
        return cursoRep.save(curso);
    }

    public void excluirCurso(Long id) {
        cursoRep.deleteById(id);
    }
}
