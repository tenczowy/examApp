package com.example.exam.services;

import com.example.exam.Pojos.QuestionRequest;
import com.example.exam.models.Question;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionService {

    List<Question> selectExam(Integer id);

    List<Question> questionsForExam(Integer id);

    String deleteQuestion(Integer id);

    Question addQuestion(QuestionRequest questionRequest);

    Question addQuestionParam(String question_name, int exam_id);
}
