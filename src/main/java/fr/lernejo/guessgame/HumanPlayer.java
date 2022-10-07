package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player{


    Logger logger = LoggerFactory.getLogger("Player");

    @Override
    public long askNextGuess() {
        Scanner in = new Scanner(System.in);
        return Long.parseLong(in.nextLine());
    }

    @Override
    public void respond(boolean lowerOrGreater) {
         if(lowerOrGreater){
             System.out.println("le nombre saisi est plus grand");
         }else {
             System.out.println("le nombre saisi est plus petit");
         }
    }

}
