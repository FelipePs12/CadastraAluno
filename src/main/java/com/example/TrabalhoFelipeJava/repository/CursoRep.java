package com.example.TrabalhoFelipeJava.repository;


import com.example.TrabalhoFelipeJava.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CursoRep extends JpaRepository<Curso, Long> {
}