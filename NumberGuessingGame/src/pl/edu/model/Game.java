package pl.edu.model;

import pl.edu.model.*;

// dodac rundy do rozgrywki

//dodac podpowiedź do menu
// wtedy będzie mówiło czy liczba jest większa czy mniejsza od podanej


public class Game {
    private int roundNumber;
    private int howManyRounds;
    private int numberOfAttempts = 3;

    public void newGame() {
        Computer comp = new Computer();
        Player player = new Player();

        System.out.println("You have " + numberOfAttempts + " attempts left.");

        int compGuess = comp.generateNumber();
        int playerGuess;

        while (numberOfAttempts > 0 && numberOfAttempts <=3) {
            playerGuess = player.getPlayerGuess();
            if (compGuess == playerGuess) {
                System.out.println("You won!");
                System.out.println("What do you want to do now?");
                return;
            } else {
                System.out.println("That's not this number.");
                System.out.println("You have " + --numberOfAttempts + " attempts left.");
//                playerGuess = player.getPlayerGuess();
            }
        }
        System.out.println("You lost the game");


    }
}
