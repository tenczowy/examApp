package com.example.exam.repositories;

import com.example.exam.models.Question;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {


    List<Question> findAllByExam_Id(int id);

    List<Question> findQuestionsById(Integer id);

    List<Question> getQuestionsById(Integer id);

    Question findQuestionById(Integer id);

    List<Question> deleteQuestionsByExam_Id(int id);







}
