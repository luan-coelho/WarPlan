package br.edu.utfpr.luancoelho.warplan.entity;

import java.time.LocalDate;

public class StudySession {

    private Long id;
    private ExamSubject examSubject;
    private LocalDate date;
    private Integer durationMinutes;
    private String notes;

    public StudySession() {

    }

    public StudySession(Long id, ExamSubject examSubject, LocalDate date, Integer durationMinutes, String notes) {
        this.id = id;
        this.examSubject = examSubject;
        this.date = date;
        this.durationMinutes = durationMinutes;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExamSubject getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(ExamSubject examSubject) {
        this.examSubject = examSubject;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}