package com.example.exam.controllers;

import com.example.exam.Pojos.AnswerRequest;
import com.example.exam.models.Answer;
import com.example.exam.services.AnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="answer")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

        @GetMapping(path = "/select/{id}")
    public @ResponseBody List<Answer> selectAnswer(@PathVariable int id){
            return answerService.selectAnswer(id);
    }

        @PostMapping(path="/deleteAnswer")
    public String deleteAnswer(@RequestParam Integer id){
        return answerService.deleteAnswer(id);
    }

    //JSON example   {"question_id":27,"answer":"Maybe now?????", "correct":false}
    @PostMapping(path="/saveAnswer")
    public Answer saveAnswer(@RequestBody AnswerRequest answerRequest){
        return answerService.saveAnswer(answerRequest);
    }

//    //PARAM VERSION
//    @PostMapping(path="/saveAnswer")
//    public Answer saveAnswer(@RequestParam  int question_id, String answerName, boolean correct){
//
//        Question question = questionRepository.findQuestionById(question_id);
//
//        Answer answer = new Answer();
//        answer.setAnswer(answerName);
//        answer.setQuestion(question);
//        answer.setCorrect(correct);
//
//        return answerRepository.save(answer);
//
//    }
}
