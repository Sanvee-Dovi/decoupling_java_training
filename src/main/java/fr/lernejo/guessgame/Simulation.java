package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Simulation {


        private final Logger logger = LoggerFactory.getLogger("simulation");
        private final Player player;  //TODO add variable type
        private long  numberToGuess; //TODO add variable type
        private long NumberGuess;
        private long min = Long.MIN_VALUE;
        private long max =Long.MAX_VALUE;


        public Simulation(Player player) {
            this.player  = player;
            //logger = LoggerFactory.getLogger(player.getClass().getName());
        }

        public void initialize(long numberToGuess) {
            this.numberToGuess = numberToGuess;
        }

        /**
         * @return true if the player have guessed the right number
         */

        private boolean nextRound() {
            if(this.player instanceof HumanPlayer) {
                long NumberGuess = player.askNextGuess();
                if (NumberGuess == this.numberToGuess) {
                    logger.log("le nombre saisi correspond bel et bien" + NumberGuess);
                    return true;
                } else if (NumberGuess > this.numberToGuess) {
                    this.player.respond(true);
                    return false;
                } else {
                    this.player.respond(false);
                    return false;
                }
            }else{
                    this.NumberGuess = this.player.askNextGuess(min,max);
                do {
                    if (NumberGuess == this.numberToGuess) {
                        logger.log("le nombre saisi correspond bel et bien : " + NumberGuess);
                        return true;
                    } else if (NumberGuess > this.numberToGuess) {
                        this.player.respond(true);
                        this.min = min;
                        this.max = NumberGuess;
                        NumberGuess = (min+max)/2;
                        return false;
                    } else {
                        this.player.respond(false);
                        this.min = NumberGuess;
                        this.max =max;
                        this.NumberGuess = (min + max)/2;
                        return false;
                    }
                }while (NumberGuess != this.numberToGuess);
            }
        }

        public void loopUntilPlayerSucceed(long maxIteration) {
            long start = System.currentTimeMillis();
            int i =0;
            do{
                nextRound();
                i++;
            }while(nextRound() !=true  && i<maxIteration);

            logger.log("jeu fini");
            logger.log("Converge au bout de : " + i  +" iterations");
            long millis = System.currentTimeMillis() - start;
            String hms = String.format("%02d:%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),millis);
            logger.log("Run time : " + hms);

        }

}
