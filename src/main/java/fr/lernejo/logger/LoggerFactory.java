package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

public class LoggerFactory {


    public static  Logger getLogger(String name){

        //Predicate<String> condition = name -> name.contains("simulation");

        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger("data.txt");
        ContextualLogger contextualLogger = new ContextualLogger(name, fileLogger);
        ContextualLogger contextualLogger1 = new ContextualLogger(name, consoleLogger);
        FilteredLogger filteredLogger = new FilteredLogger(contextualLogger,n->name.contains("simulation"));
        FilteredLogger filteredLogger1 = new FilteredLogger(contextualLogger1,n->!name.contains("simulation"));
        CompositeLogger compositeLogger = new CompositeLogger(filteredLogger,filteredLogger1);

        return new Logger() {
            @Override
            public void log(String message) {
                compositeLogger.log(message);
            }
        };
    }
}
