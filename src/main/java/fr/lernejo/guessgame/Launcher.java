package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
     public static void main(String[] args) {

         HumanPlayer humanPlayer = new HumanPlayer();
         Simulation simulation = new Simulation(humanPlayer);
         SecureRandom random = new SecureRandom();
         long  numberRandom = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
         simulation.initialize(numberRandom);
         simulation.loopUntilPlayerSucceed();

    }
}
