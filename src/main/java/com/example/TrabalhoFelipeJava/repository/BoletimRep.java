package com.example.TrabalhoFelipeJava.repository;


import com.example.TrabalhoFelipeJava.model.Aluno;
import com.example.TrabalhoFelipeJava.model.Boletim;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface BoletimRep extends JpaRepository<Boletim, Long> {
    List<Boletim> findByAluno(Aluno aluno);
}