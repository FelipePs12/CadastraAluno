package com.example.TrabalhoFelipeJava.repository;


import com.example.TrabalhoFelipeJava.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DisciplinaRep extends JpaRepository<Disciplina, Long> {
}