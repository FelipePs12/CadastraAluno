package com.example.TrabalhoFelipeJava.controller;


import com.example.TrabalhoFelipeJava.model.Aluno;
import com.example.TrabalhoFelipeJava.model.Boletim;
import com.example.TrabalhoFelipeJava.service.AlunoSer;
import com.example.TrabalhoFelipeJava.service.BoletimSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boletim")
public class BoletimCtl {
    @Autowired
    private BoletimSer bolService;
    private com.example.TrabalhoFelipeJava.service.AlunoSer AlunoSer;

    @GetMapping("/aluno/{alunoId}")
    public List<Boletim> obterBoletimPorAluno(@PathVariable Long alunoId) {
        Aluno aluno = AlunoSer.obterAlunoPorId(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return bolService.obterBoletimPorAluno(aluno);
    }
}