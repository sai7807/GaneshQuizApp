package com.Quizapp.GaneshQuizApp.Service;

import com.Quizapp.GaneshQuizApp.model.Question;
import com.Quizapp.GaneshQuizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
//        Question q=new Question();
//        q.setQuestion_title("Hello World!");
//        questionDao.save(q);
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(List<Question> question) {
        try {
            for (Question q : question) {
                questionDao.save(q);
            }
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question Not Added", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestionById(int id) {
        try {
            return Optional.ofNullable(id)
                    .filter(questionDao::existsById)
                    .map(existingId -> {
                        questionDao
                                .deleteById(existingId);
                        return new ResponseEntity<>("Question Deleted Successfully", HttpStatus.OK);
                    })
                    .orElse(new ResponseEntity<>("Question Not Found", HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting question", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> update(@PathVariable int id) {
        Optional<Question> q = questionDao.findById(id);
        Question question = null;
        if (q.isPresent()) {
            question = q.get();
        }
        question.setCategory("SQL");
        question.setQuestion_title("What is sql?");
//        question.setDifficulty_level(update.getDifficulty_level());
//        question.setOption1(update.getOption1());
//        question.setOption2(update.getOption2());
//        question.setOption3(update.getOption3());
//        question.setCorrect_answer(update.getCorrect_answer());
        questionDao.save(question);
        return new ResponseEntity<>("Question Updated Successfully", HttpStatus.OK);





    }
}

//    public ResponseEntity<String> updatedQuestion(int id, Question question){
//        try {
//            Optional<Question> existingQuestion = questionDao.findById(id);
//
//            Optional<Object> existingQuestionOpt = Optional.empty();
//            if (existingQuestionOpt.isPresent()) {
//                Question existingQuestion = existingQuestionOpt.get();
//            }
//
//            Attribute updatedQuestion = null;
//            if (updatedQuestion.getCategory() != null) {
//                existingQuestion.stream(updatedQuestion.getCategory());
//            }
//            if (updatedQuestion.getDifficulty_level() != null) {
//                existingQuestion.setDifficulty_level(updatedQuestion.getDifficulty_level());
//            }
//            if (updatedQuestion.getOption1() != null) {
//                existingQuestion.setOption1(updatedQuestion.getOption1());
//            }
//            if (updatedQuestion.getOption2() != null) {
//                existingQuestion.setOption2(updatedQuestion.getOption2());
//            }
//            if (updatedQuestion.getOption3() != null) {
//                existingQuestion.setOption3(updatedQuestion.getOption3());
//            }
//            if (updatedQuestion.getQuestion_title() != null) {
//                existingQuestion.setQuestion_title(updatedQuestion.getQuestion_title());
//            }
//            if (updatedQuestion.getCorrect_answer() != null) {
//                existingQuestion.setCorrect_answer(updatedQuestion.getCorrect_answer());
//            }
//            questionDao.save(existingQuestion);
//            return new ResponseEntity<>("Question updated successfully", HttpStatus.OK);
//
//            } else {
//                // If the question doesn't exist
//                return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
//            }
//    }

