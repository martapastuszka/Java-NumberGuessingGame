package pl.edu;

import pl.edu.model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GamePlay {

    private int roundNumber = 1;
    private int numberOfAttempts = 3;

    PlayerManager playerManager = new PlayerManager();

    public void start() {
        System.out.println();
        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Computer picks a number range 0-10,");
        System.out.println("Your task is guess which it picked. There are 3 rounds, You have 3 attempts in each round. Good luck!");

        MenuManager menu = new MenuManager();
//        PlayerManager playerManager = new PlayerManager();

        for (; ; ) {
            int o = menu.showMenu();

            switch (o) {
                case 0 -> {
                    System.out.println("Thank you bye bye!");
                    return;
                }
                case 1 -> {
                  newGame();
                  saveResults();
                }
                default -> {
                    System.out.println("Pick either 0 or 1!");
                }
            }
        }
    }

    public void newGame(){
        Computer comp = new Computer();
        String name = playerManager.createPlayer();

        System.out.println("Hello " + name + "!");
        playerManager.playerInfo();

        System.out.println("You have " + numberOfAttempts + " attempts left.");

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
        }
    }

    public void saveResults(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("tableResults.txt"));
            for (Player player : playerManager.getPlayers()){
                writer.write("\nName: " + player.getName() + ", score: " + playerManager.getPlayerScore());
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
