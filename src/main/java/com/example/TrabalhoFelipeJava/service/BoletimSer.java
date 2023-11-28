package com.example.TrabalhoFelipeJava.service;

import com.example.TrabalhoFelipeJava.model.Aluno;
import com.example.TrabalhoFelipeJava.model.Boletim;
import com.example.TrabalhoFelipeJava.repository.BoletimRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletimSer{
    @Autowired
    private BoletimRep boletimRep;

    public List<Boletim> obterBoletimPorAluno(Aluno aluno) {
        return boletimRep.findByAluno(aluno);
    }
}