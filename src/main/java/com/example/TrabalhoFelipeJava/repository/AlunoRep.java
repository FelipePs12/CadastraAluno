package com.example.TrabalhoFelipeJava.repository;


import com.example.TrabalhoFelipeJava.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRep extends JpaRepository<Aluno, Long> {
}
