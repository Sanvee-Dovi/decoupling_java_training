package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerFactory {

    public static  Logger getLogger(String name){
            FileLogger fileLogger = new FileLogger("C:\\Users\\hp\\TP_archi_log\\decoupling_java_training\\data.txt");
            return new Logger() {
            @Override
            public void log(String message) {
               fileLogger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + ": " + name + ": " + message);
            }
        };
        //ContextualLogger contextualLogger = new ContextualLogger(name,logger);

       // return contextualLogger.log(name);
    }
}
