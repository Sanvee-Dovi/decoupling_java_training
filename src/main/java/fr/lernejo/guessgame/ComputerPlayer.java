package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{

    Logger logger = LoggerFactory.getLogger("Robot");

    @Override
    public long askNextGuess(long min , long max)  {
       return (min+max)/2;
    }


    @Override
    public long askNextGuess() {
        return 0;
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
