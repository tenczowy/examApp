package com.example.exam.controllers;

import com.example.exam.models.Exam;
import com.example.exam.services.ExamService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="exam")
public class ExamController {


    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewExam (@RequestParam String name) {
        return examService.addNewExam(name);
    }


    @GetMapping(path="/select")
    public @ResponseBody Iterable<Exam> selectExam(@RequestParam String name){
        return examService.selectExam(name);
    }




    @GetMapping(path = "/list")
    public @ResponseBody Iterable<Exam> findAllExams(){

        return examService.findAll();
    }

}
