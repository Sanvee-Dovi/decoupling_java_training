package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player{


    Logger logger = LoggerFactory.getLogger("Player");

    @Override
    public long askNextGuess(long min, long max) {
        return 0;
    }

    @Override
    public long askNextGuess() {
        logger.log("veuillez saisir un nombre :");
        Scanner in = new Scanner(System.in);
        return Long.parseLong(in.nextLine());
    }



    @Override
    public void respond(boolean lowerOrGreater) {
         if(lowerOrGreater){
             logger.log("le nombre saisi est plus grand");
         }else {
             logger.log("le nombre saisi est plus petit");
         }
    }

}
