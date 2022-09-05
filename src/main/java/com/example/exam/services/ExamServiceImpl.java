package com.example.exam.services;

import com.example.exam.models.Exam;
import com.example.exam.repositories.AnswerRepository;
import com.example.exam.repositories.ExamRepository;
import com.example.exam.repositories.QuestionRepository;
import org.springframework.stereotype.Service;


@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public ExamServiceImpl(ExamRepository examRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.examRepository = examRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
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

    @Override
    public String delete(int id) {
        answerRepository.deleteAnswersByQuestion_Exam_Id(id);
        questionRepository.deleteQuestionsByExam_Id(id);
        examRepository.deleteById(id);
        return "Exam deleted successfully!";
    }


}

