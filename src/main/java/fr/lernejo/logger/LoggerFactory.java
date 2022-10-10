package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerFactory {


    public static  Logger getLogger(String name){

        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger("data.txt");
        ContextualLogger contextualLogger = new ContextualLogger(name, fileLogger);
        ContextualLogger contextualLogger1 = new ContextualLogger(name, consoleLogger);
        CompositeLogger compositeLogger = new CompositeLogger(contextualLogger,contextualLogger1);

        return new Logger() {
            @Override
            public void log(String message) {
                compositeLogger.log(message);
            }
        };
    }
}
