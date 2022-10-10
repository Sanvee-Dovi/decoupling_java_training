package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {

    private Logger logger;
    private String name;
    public ContextualLogger(String name, Logger logger){
        this.logger = logger;
        this.name = name;
    }
    @Override
    public void log(String message) {
        this.logger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " " + logger.getClass().getName() + " " + message);
    }
}
