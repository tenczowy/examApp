package com.example.exam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @SequenceGenerator(name = "question_sequence", sequenceName = "question_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_sequence")
    private Integer id;

    @Column
    private String questionName;

    @ManyToOne
    private Exam exam;

    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return questionName;
    }

    public void setQuestion(String question) {
        this.questionName = question;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }






}
