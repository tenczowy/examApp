package com.example.exam.controllers;

import com.example.exam.models.Exam;
import com.example.exam.services.ExamService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @PostMapping(path="/delete/{id}")
    public String deleteExam(@PathVariable int id){
            return examService.delete(id);
    }

    @GetMapping(path = "/list")
    public @ResponseBody Iterable<Exam> findAllExams(){

        return examService.findAll();
    }



}
