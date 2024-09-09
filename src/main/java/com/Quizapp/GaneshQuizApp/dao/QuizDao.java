package com.Quizapp.GaneshQuizApp.dao;

import com.Quizapp.GaneshQuizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
    Optional<Quiz> findAllById(Integer id);
}
