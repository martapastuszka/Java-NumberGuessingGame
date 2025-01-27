package pl.edu.model;

import java.util.ArrayList;
import java.util.List;

// dodac rundy do rozgrywki

// mozliwosc dodania imienia gracza
// mozliwosc przechowywania wynikow gracza w pliku
//dodac podpowiedź do menu
// wtedy będzie mówiło czy liczba jest większa czy mniejsza od podanej


public class Game {
    private int roundNumber = 1;
    private int numberOfAttempts = 3;

    public void newGame() {
        Computer comp = new Computer();
        PlayerManager playerManager = new PlayerManager();
        String name = playerManager.createPlayer();


        System.out.println("Hello " + name + "!");
        playerManager.playerInfo();

        System.out.println("You have " + numberOfAttempts + " attempts left.");

//        int compGuess;
        int playerGuess;
        int playerScore = playerManager.getPlayerScore();
        int compGuess;

        for (roundNumber = 1; roundNumber < 4; roundNumber++) {
            System.out.println("Round number: " + roundNumber);
            compGuess = comp.generateNumber();
            numberOfAttempts = 3;
            while (numberOfAttempts > 0 && numberOfAttempts <= 3) {
                playerGuess = playerManager.setPlayerGuess();
                if (compGuess == playerGuess) {
                    System.out.println("You won!");
                    playerScore++;
                    System.out.println("Your score: " + playerScore + " points.");
                    playerManager.setPlayerScore(playerScore);
                    break;
                } else {
                    System.out.println("That's not this number.");
                    --numberOfAttempts;
                    System.out.println("You have " + numberOfAttempts + " attempts left.");
                }

            }
            playerManager.playerInfo();
            System.out.println("What do you want to do now?");

//            System.out.println("You lost the game");
        }

        //next:
        // obsłużyć else (od 44 linii)


    }

}
