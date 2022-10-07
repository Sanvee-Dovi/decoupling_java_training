package fr.lernejo.logger;

public class LoggerFactory {
    public static  Logger getLogger(String name){
        return new Logger() {
            @Override
            public void log(String message) {
                System.out.println(message);
            }
        };
    }
}
