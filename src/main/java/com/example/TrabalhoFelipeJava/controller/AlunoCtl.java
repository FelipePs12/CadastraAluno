package com.example.TrabalhoFelipeJava.controller;

import com.example.TrabalhoFelipeJava.model.Aluno;
import com.example.TrabalhoFelipeJava.service.AlunoSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoCtl {

    @Autowired
    private AlunoSer aluService;

    @PostMapping
    public ResponseEntity<Object> cadastrarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.OK).body(aluService.cadastrarAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> allAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(aluService.listarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> alunosCodigo(@PathVariable(value = "id") Long id) {
        Optional<Aluno> alunoOptional = aluService.obterAlunoPorId(id);

        if (alunoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(alunoOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizaAluno(@PathVariable(value = "id") Long id, @RequestBody Aluno alunoAtualizado) {
        Optional<Aluno> alunoOptional = aluService.obterAlunoPorId(id);

        if (alunoOptional.isPresent()) {
            Aluno alunoExistente = alunoOptional.get();
            alunoExistente.setNome(alunoAtualizado.getNome());
            alunoExistente.setNotas(alunoAtualizado.getNotas());

            aluService.cadastrarAluno(alunoExistente);

            return ResponseEntity.status(HttpStatus.OK).body("Aluno atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaAluno(@PathVariable(value = "id") Long id) {
        Optional<Aluno> alunoOptional = aluService.obterAlunoPorId(id);

        if (alunoOptional.isPresent()) {
            aluService.excluirAluno(id);
            return ResponseEntity.status(HttpStatus.OK).body("Aluno removido!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
    }
}