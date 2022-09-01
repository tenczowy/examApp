package com.example.exam.repositories;

import com.example.exam.models.Question;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface QuestionRepository extends CrudRepository<Question, Integer> {


    @Query("select questions from Exam e where e.id = ?1")
    List<Question> getQuestionsByExam(Integer id);

    List<Question> findQuestionsById(Integer id);

    List<Question> getQuestionsById(Integer id);

    Question findQuestionById(Integer id);






}