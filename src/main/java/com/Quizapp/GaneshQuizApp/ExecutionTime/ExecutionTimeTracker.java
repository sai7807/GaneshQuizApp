//package com.Quizapp.GaneshQuizApp.ExecutionTime;
//
//import org.aspectj.lang.annotation.Aspect;
//
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import java.util.logging.Logger;
//
//@Aspect
//@Component
//public class ExecutionTimeTracker {
//        Logger logger = (Logger) LoggerFactory.getLogger(ExecutionTimeTracker.class);
//}
package com.Quizapp.GaneshQuizApp.ExecutionTime;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTracker {
        // Use the SLF4J Logger directly
        private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeTracker.class);

        // You can now use `logger` to log messages
        public void logExample() {
                logger.info("Logging from ExecutionTimeTracker");
        }
}
