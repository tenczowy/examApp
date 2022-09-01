package com.example.exam.repositories;

import com.example.exam.models.Answer;
import com.example.exam.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {
    List<Answer> findAnswerById(Integer id);
}
