package com.example.exam.services;

import com.example.exam.DAO.QuestionRequest;
import com.example.exam.models.Exam;
import com.example.exam.models.Question;
import com.example.exam.repositories.AnswerRepository;
import com.example.exam.repositories.ExamRepository;
import com.example.exam.repositories.QuestionRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService{

    private final QuestionRepository questionRepository;
    private final ExamRepository examRepository;

    private final AnswerRepository answerRepository;

    public QuestionServiceImp(QuestionRepository questionRepository, ExamRepository examRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.examRepository = examRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Question> selectExam(Integer id) {
        return questionRepository.findQuestionsById(id);
    }

    @Override
    public List<Question> questionsForExam(Integer id) {
        return questionRepository.findAllByExam_Id(id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public String deleteQuestion(Integer id) {
        try{
            answerRepository.deleteAnswersByQuestion_Id(id);
            questionRepository.deleteById(id);
            return "Question deleted successfully";
        }catch (EmptyResultDataAccessException exception){
            return "Question not found.";
        }

    }

    @Override
    public Question addQuestion(QuestionRequest questionRequest) {
        Exam exam = examRepository.findById(questionRequest.exam_id);

        Question question = new Question();
        question.setQuestion(questionRequest.question_name);
        question.setExam(exam);

        return questionRepository.save(question);
    }

    @Override
    public Question addQuestionParam(String question_name, int exam_id) {
        Exam exam = examRepository.findById(exam_id);

        Question question = new Question();
        question.setQuestion(question_name);
        question.setExam(exam);

        return questionRepository.save(question);
    }

}
