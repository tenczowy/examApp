package com.example.exam.repositories;

import com.example.exam.models.Exam;
import com.example.exam.models.Question;
import com.example.exam.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ExamRepository extends CrudRepository<Exam, Integer>{
    List<Exam> findExamByExamName(String name);

    List<User> deleteExamByExamName(String name);

    boolean existsExamByExamName(String name);

    Exam findById(int id);



}
