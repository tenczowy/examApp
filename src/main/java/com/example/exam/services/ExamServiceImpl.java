package com.example.exam.services;

import com.example.exam.models.Exam;
import com.example.exam.repositories.AnswerRepository;
import com.example.exam.repositories.ExamRepository;
import com.example.exam.repositories.QuestionRepository;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;


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
    public String delete(int id){
        try {
            answerRepository.deleteAnswersByQuestion_Exam_Id(id);
            questionRepository.deleteQuestionsByExam_Id(id);
            examRepository.deleteById(id);
            return "Exam deleted successfully!";
        }catch (EmptyResultDataAccessException | HttpClientErrorException.BadRequest e){
            return "Exam not found.";
        }
    }


}

