package com.Quizapp.GaneshQuizApp.dao;


import com.Quizapp.GaneshQuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q Where q.category= :category ORDER BY RANDOM() LIMIT :numq", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numq);
}
