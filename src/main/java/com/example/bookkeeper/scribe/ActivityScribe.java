package com.example.bookkeeper.scribe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ActivityScribe {

    public ActivityScribe(){

    }

    public void logEntry(Class classObject, String message, ActivityScribeLoggingLevels level){
        Logger logger = LoggerFactory.getLogger(classObject);

        switch(level){
            case TRACE:
                logger.trace(message);
                break;
            case DEBUG:
                logger.debug(message);
            case INFO:
                logger.info(message);
                break;
            case WARN:
                logger.warn(message);
                break;
            case ERROR:
                logger.error(message);
                break;
        }
    }
}
