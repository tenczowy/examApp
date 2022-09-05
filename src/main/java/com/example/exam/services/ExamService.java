package com.example.exam.services;

import com.example.exam.models.Exam;
import org.springframework.stereotype.Service;

@Service
public interface ExamService {

    String addNewExam(String name);


    Iterable<Exam> selectExam(String name);

    Iterable<Exam> findAll();
}
