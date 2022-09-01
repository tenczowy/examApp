package com.example.exam.controllers;

import com.example.exam.Pojos.AnswerRequest;
import com.example.exam.Pojos.QuestionRequest;
import com.example.exam.models.Answer;
import com.example.exam.models.Exam;
import com.example.exam.models.Question;
import com.example.exam.repositories.AnswerRepository;
import com.example.exam.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="answer")
public class AnswerController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

//    @GetMapping(path = "/select")
//    public @ResponseBody List<Answer> selectAnswer(@RequestParam Integer id){
//        return answerRepository.findAnswerById(id);
//    }

    @GetMapping(path = "/select/{id}")
    public @ResponseBody List<Answer> selectAnswer(@PathVariable int id){
        return answerRepository.findAnswerById(id);
    }

    //delete by id
    @PostMapping(path="/deleteAnswer")
    public String deleteAnswer(@RequestParam Integer id){
        answerRepository.deleteById(id);
        return "answer deleted successfully!";
    }


    //ANSWER OBJECT
    @PostMapping(path="/saveAnswer2")
    public Answer saveAnswer2(@RequestBody Answer answer){
        return answerRepository.save(answer);
    }

    //JSON example   {"question_id":27,"answer":"Maybe now?????", "correct":false}
    @PostMapping(path="/saveAnswer3")
    public Answer saveAnswer3(@RequestBody AnswerRequest answerRequest){
        Question question = questionRepository.findQuestionById(answerRequest.question_id);

        Answer answer = new Answer();
        answer.setAnswer(answerRequest.answer);
        answer.setQuestion(question);
        answer.setCorrect(answerRequest.correct);

        return answerRepository.save(answer);
    }


    //PARAM VERSION
    @PostMapping(path="/saveAnswer")
    public Answer saveAnswer(@RequestParam  int question_id, String answerName, boolean correct){

        Question question = questionRepository.findQuestionById(question_id);

        Answer answer = new Answer();
        answer.setAnswer(answerName);
        answer.setQuestion(question);
        answer.setCorrect(correct);

        return answerRepository.save(answer);

    }
}
