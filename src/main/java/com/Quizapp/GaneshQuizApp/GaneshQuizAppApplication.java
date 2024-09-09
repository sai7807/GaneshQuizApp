package com.Quizapp.GaneshQuizApp;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GaneshQuizAppApplication {

	public static void main(String[] args) {
//        ConfigurableApplicationContext ap =SpringApplication.run(GaneshQuizAppApplication.class, args);
//	            QuestionController obj=ap.getBean(QuestionController.class);
//                System.out.println(obj.getAllQuestions());
        SpringApplication.run(GaneshQuizAppApplication.class,args);
    }

}
