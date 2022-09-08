package com.example.exam.controllers;


import com.example.exam.DAO.QuestionRequest;
import com.example.exam.models.Question;
import com.example.exam.services.QuestionService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/select")
    public @ResponseBody List<Question> selectExam(@RequestParam Integer id) {
        return questionService.selectExam(id);
    }

    @GetMapping(path = "/questionsForExam/{id}")
    public @ResponseBody List<Question> questionsForExam(@PathVariable Integer id) {
        return questionService.questionsForExam(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @PostMapping(path = "/delete/{id}")
    public @ResponseBody String deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }

    @PostMapping(path = "/add")
    public Question addQuestion(@RequestBody QuestionRequest questionRequest) {
        return questionService.addQuestion(questionRequest);
    }

    @PostMapping(path = "/addQuestionParam")
    public Question addQuestionParam(@RequestParam String question_name, int exam_id) {
        return questionService.addQuestionParam(question_name, exam_id);
    }
}
