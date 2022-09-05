package com.example.exam.services;

import com.example.exam.Pojos.QuestionRequest;
import com.example.exam.models.Exam;
import com.example.exam.models.Question;
import com.example.exam.repositories.ExamRepository;
import com.example.exam.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService{

    private final QuestionRepository questionRepository;
    private final ExamRepository examRepository;

    public QuestionServiceImp(QuestionRepository questionRepository, ExamRepository examRepository) {
        this.questionRepository = questionRepository;
        this.examRepository = examRepository;
    }

    @Override
    public List<Question> selectExam(Integer id) {
        return questionRepository.findQuestionsById(id);
    }

    @Override
    public List<Question> questionsForExam(Integer id) {
        return questionRepository.findAllByExam_Id(id);
    }

    @Override
    public String deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
        return "Question deleted successfully";
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
