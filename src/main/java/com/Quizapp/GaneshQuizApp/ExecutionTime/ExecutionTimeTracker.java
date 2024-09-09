package com.Quizapp.GaneshQuizApp.ExecutionTime;

import org.aspectj.lang.annotation.Aspect;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ExecutionTimeTracker {
        Logger logger = (Logger) LoggerFactory.getLogger(ExecutionTimeTracker.class);


}
