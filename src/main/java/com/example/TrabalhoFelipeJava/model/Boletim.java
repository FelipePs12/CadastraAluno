package com.example.TrabalhoFelipeJava.model;

import jakarta.persistence.*;

@Entity
public class Boletim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    private String status;

    @ManyToOne
    @JoinColumn(name = "ID_ALUNO")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "ID_DISCIPLINA")
    private Disciplina disciplina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @PrePersist
    public void prePersist() {
        validarNota();
        calcularStatus();
    }

    @PreUpdate
    public void preUpdate() {
        validarNota();
        calcularStatus();
    }

    private void validarNota() {
        if (valor == null || valor < 0 || valor > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10");
        }
    }

    private void calcularStatus() {
        if (valor == null) {
            status = "Ativo";
        } else {
            status = valor >= 7 ? "Aprovado" : "Reprovado";
        }
    }
}