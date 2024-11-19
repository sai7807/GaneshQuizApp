package com.Quizapp.GaneshQuizApp.Contoller;


import com.Quizapp.GaneshQuizApp.Service.QuizService;
import com.Quizapp.GaneshQuizApp.model.Question;
import com.Quizapp.GaneshQuizApp.model.QuestionWrapper;
import com.Quizapp.GaneshQuizApp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
            return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<String> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
        responses.forEach(n->System.out.println(n));
        System.out.println("ok");
        return quizService.calculateResult(id, responses);
        //return new ResponseEntity<>(String.valueOf(0), HttpStatus.OK);
    }



}