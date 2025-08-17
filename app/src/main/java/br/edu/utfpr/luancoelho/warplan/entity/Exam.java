package br.edu.utfpr.luancoelho.warplan.entity;

import java.time.LocalDate;

public class Exam {

    private Long id;
    private String name;
    private String description;
    private LocalDate examDate;

    public Exam() {

    }

    public Exam(Long id, String name, String description, LocalDate examDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.examDate = examDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

}