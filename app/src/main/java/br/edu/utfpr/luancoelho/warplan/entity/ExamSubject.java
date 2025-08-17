package br.edu.utfpr.luancoelho.warplan.entity;

public class ExamSubject {

    private Long id;
    private Exam exam;
    private Subject subject;
    private Double weight;
    private Priority priority;

    public ExamSubject() {

    }

    public ExamSubject(Long id, Exam exam, Subject subject, Double weight, Priority priority) {
        this.id = id;
        this.exam = exam;
        this.subject = subject;
        this.weight = weight;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

}