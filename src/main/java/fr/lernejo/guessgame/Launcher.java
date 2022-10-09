package fr.lernejo.guessgame;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Scanner;

public class Launcher {
     public static void main(String[] args) {
         if(Objects.equals(args[0], "-interactive")) {
             HumanPlayer humanPlayer = new HumanPlayer();
             Simulation simulation = new Simulation(humanPlayer);
             SecureRandom random = new SecureRandom();
             long numberRandom = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
             simulation.initialize(numberRandom);
             simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
         }else if(Objects.equals(args[0], "-auto") && args[1].matches("[+-]?\\d*(\\.\\d+)?")){
             ComputerPlayer computerPlayer = new ComputerPlayer();
             Simulation simulation = new Simulation(computerPlayer);
             simulation.initialize(Long.parseLong(args[1]));
             simulation.loopUntilPlayerSucceed(1000);
         }else{
             System.out.println("Pour lancer  HumanPlayer : args[0] = -iterative , pour lancer  ComputerPlayer : args[0] = auto et args[1] doit etre numeric");
         }
    }
}
