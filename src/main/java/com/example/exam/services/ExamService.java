package com.example.exam.services;

import com.example.exam.models.Exam;

public interface ExamService {

    String addNewExam(String name);


    Iterable<Exam> selectExam(String name);

    Iterable<Exam> findAll();
}
