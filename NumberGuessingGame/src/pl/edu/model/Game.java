package pl.edu.model;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private int roundNumber = 1;
    private int numberOfAttempts = 3;

    public Player newGame() {
        Player player = new Player();

        for (roundNumber = 1; roundNumber < 4; roundNumber++) {
            System.out.println("Round number: " + roundNumber);
            int compGuess = generateNumber();
            numberOfAttempts = 3;

            while (numberOfAttempts > 0 && numberOfAttempts <= 3) {
                //set player guess
                Scanner scanner = new Scanner(System.in);
                System.out.println("Pick a number range from 1-10: ");
                int playerGuess = scanner.nextInt();

                //compare computerGuess with playerGuess
                if (compGuess == playerGuess) {
                    System.out.println("You won!");
                    int score = player.getScore();
                    player.setScore(score + 1);
                    System.out.println("Your score: " + player.getScore() + " points.");
                    break;
                } else {
                    System.out.println("That's not this number.");
                    --numberOfAttempts;
                    System.out.println("You have " + numberOfAttempts + " attempts left.");
                }
            }
        }

        return player;
    }

    public int generateNumber() {
        Random random = new Random();
        int randomInt = random.nextInt(11);
        System.out.println("[TEST]Computer guess: " + randomInt);

        return randomInt;
    }

}
