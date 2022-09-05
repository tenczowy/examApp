package com.example.exam.services;

import com.example.exam.models.Exam;
import com.example.exam.repositories.ExamRepository;
import org.springframework.stereotype.Service;


@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;

    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }


    @Override
    public String addNewExam(String name) {
        Exam n = new Exam();
        n.setExamName(name);
        examRepository.save(n);
        return "Saved";
    }

    @Override
    public Iterable<Exam> selectExam(String name) {
        return examRepository.findExamByExamName(name);
    }

    @Override
    public Iterable<Exam> findAll() {
            return examRepository.findAll();
    }


}

