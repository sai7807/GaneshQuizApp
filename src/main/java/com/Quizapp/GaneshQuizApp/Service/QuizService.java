package com.Quizapp.GaneshQuizApp.Service;

import com.Quizapp.GaneshQuizApp.dao.QuestionDao;
import com.Quizapp.GaneshQuizApp.dao.QuizDao;
import com.Quizapp.GaneshQuizApp.model.Question;
import com.Quizapp.GaneshQuizApp.model.QuestionWrapper;
import com.Quizapp.GaneshQuizApp.model.Quiz;
import com.Quizapp.GaneshQuizApp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, Integer numq, String title){
        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numq);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findAllById(id);
        List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for (Question q: questionFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(), q.getOption2(),q.getOption3());
            questionForUser.add(qw);
        }
            return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<String> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        if(responses !=null){
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getCorrect_answer()))
                right++;

            i++;}
        }
        return new ResponseEntity<>(String.valueOf(right), HttpStatus.OK);

    }
}
