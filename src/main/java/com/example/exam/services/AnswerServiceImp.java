package com.example.exam.services;

import com.example.exam.DAO.AnswerRequest;
import com.example.exam.models.Answer;
import com.example.exam.models.Question;
import com.example.exam.repositories.AnswerRepository;
import com.example.exam.repositories.QuestionRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImp implements AnswerService{
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerServiceImp(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }


    @Override
    public List<Answer> selectAnswer(Integer id) {
        return answerRepository.findAnswerById(id);
    }

    @Override
    public String deleteAnswer(Integer id) {
        try{
            answerRepository.deleteById(id);
            return "answer deleted successfully!";
        }catch (EmptyResultDataAccessException e){
            return "Answer not found.";
        }
    }

    @Override
    public Answer saveAnswer(AnswerRequest answerRequest) {
        Question question = questionRepository.findQuestionById(answerRequest.question_id);

        Answer answer = new Answer();
        answer.setAnswer(answerRequest.answer);
        answer.setQuestion(question);
        answer.setCorrect(answerRequest.correct);

        return answerRepository.save(answer);
    }


}
