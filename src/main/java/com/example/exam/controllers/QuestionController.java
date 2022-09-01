package com.example.exam.controllers;


import com.example.exam.Pojos.QuestionRequest;
import com.example.exam.models.Exam;
import com.example.exam.models.Question;
import com.example.exam.repositories.ExamRepository;
import com.example.exam.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ExamRepository examRepository;


    @GetMapping(path="/select")
    public @ResponseBody List<Question> selectExam(@RequestParam Integer id){
        return questionRepository.findQuestionsById(id);
    }

    @GetMapping(path="/questionsForExam")
    public @ResponseBody List<Question> questionsForExam(@RequestParam Integer id){
        return questionRepository.getQuestionsByExam(id);
    }

    //DELETE QUESTION BY ID
    @PostMapping(path="/deleteQuestion")
    public @ResponseBody String deleteQuestion(@RequestParam Integer id){
        questionRepository.deleteById(id);
        return "Question deleted successfully.";
    }


    //QUESTION OBJECT
    @PostMapping(path="/saveQuestion2")
    public Question saveQuestion2(@RequestBody Question question){
        return questionRepository.save(question);
    }

    //JSON version
    @PostMapping(path="/addQuestion2")
    public Question addQuestion(@RequestBody QuestionRequest questionRequest){

        Exam exam = examRepository.findById(questionRequest.exam_id);

        Question question = new Question();
        question.setQuestion(questionRequest.question_name);
        question.setExam(exam);

        return questionRepository.save(question);

    }


    //PARAM VERSION
    @PostMapping(path="/addQuestion")
    public Question addQuestion2(@RequestParam String question_name, int exam_id){

        Exam exam = examRepository.findById(exam_id);

        Question question = new Question();
        question.setQuestion(question_name);
        question.setExam(exam);

        return questionRepository.save(question);

    }









}
