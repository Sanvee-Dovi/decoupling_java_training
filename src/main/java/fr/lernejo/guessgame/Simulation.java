package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class Simulation {


        private final Logger logger = LoggerFactory.getLogger("simulation");
        private final Player player;  //TODO add variable type
        private long  numberToGuess; //TODO add variable type

        public Simulation(Player player) {
            this.player  = player;
        }

        public void initialize(long numberToGuess) {
            this.numberToGuess = numberToGuess;
        }

        /**
         * @return true if the player have guessed the right number
         */
        private boolean nextRound() {
            logger.log("veuillez saisir un nombre :");
            long NumberGuess = player.askNextGuess();
            if(NumberGuess == this.numberToGuess){
                logger.log("le nombre saisi correspond bel et bien");
                return true;
            }else if(NumberGuess > this.numberToGuess){
                this.player.respond(true);
                return false;
            }else{
                this.player.respond(false);
                return false;
            }



        }

        public void loopUntilPlayerSucceed() {
            while(nextRound() != true){
                nextRound();
            }
            logger.log("jeu fini");

        }

}
