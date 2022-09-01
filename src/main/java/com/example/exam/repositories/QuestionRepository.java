package com.example.exam.repositories;

import com.example.exam.models.Question;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface QuestionRepository extends CrudRepository<Question, Integer> {


    List<Question> findAllByExam_Id(int id);

    List<Question> findQuestionsById(Integer id);

    List<Question> getQuestionsById(Integer id);

    Question findQuestionById(Integer id);






}
