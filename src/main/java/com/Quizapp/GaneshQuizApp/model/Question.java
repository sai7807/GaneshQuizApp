package com.Quizapp.GaneshQuizApp.model;

import jakarta.persistence.*;

import lombok.Data;



@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO ,generator = "question_seq")
//    @SequenceGenerator(name = "question_seq", sequenceName = "question_sequence", allocationSize = 1)

    private Integer id;
    private String category;
    private String difficulty_level;
    private String option1;
    private String option2;
    private String option3;
    private String question_title;
    private String correct_answer;

}
