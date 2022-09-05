package com.example.exam.controllers;


import com.example.exam.Pojos.QuestionRequest;
import com.example.exam.models.Question;
import com.example.exam.services.QuestionService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
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

    @GetMapping(path = "/questionsForExam")
    public @ResponseBody List<Question> questionsForExam(@RequestParam Integer id) {
        return questionService.questionsForExam(id);
    }

    @PostMapping(path = "/deleteQuestion")
    public @ResponseBody String deleteQuestion(@RequestParam Integer id) {
        return questionService.deleteQuestion(id);
    }

    @PostMapping(path = "/addQuestion")
    public Question addQuestion(@RequestBody QuestionRequest questionRequest) {
        return questionService.addQuestion(questionRequest);
    }

    @PostMapping(path = "/addQuestionParam")
    public Question addQuestionParam(@RequestParam String question_name, int exam_id) {
        return questionService.addQuestionParam(question_name, exam_id);
    }
}
