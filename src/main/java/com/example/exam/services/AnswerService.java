package com.example.exam.services;

import com.example.exam.DAO.AnswerRequest;
import com.example.exam.models.Answer;

import java.util.List;

public interface AnswerService{

    List<Answer> selectAnswer(Integer id);

    String deleteAnswer(Integer id);

    Answer saveAnswer(AnswerRequest answerRequest);
}
