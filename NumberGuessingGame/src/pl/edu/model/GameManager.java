package pl.edu.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
    private List<Player> players = new ArrayList<>();
    private int roundNumber = 1;
    private int numberOfAttempts = 3;

    public void start() {
        System.out.println();
        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Computer picks a number range 0-10,");
        System.out.println("Your task is guess which it picked. There are 3 rounds, You have 3 attempts in each round. Good luck!");

        Menu menu = new Menu();
        for (; ; ) {
            int o = menu.showMenu();

            switch (o) {
                case 0 -> {
                    System.out.println("Thank you bye bye!");
                    return;
                }
                case 1 -> {
                    Game game = new Game();
                    Player player = game.newGame();
                    players.add(player);
                    playerInfo();
                    savePlayers();
                }
                default -> {
                    System.out.println("Pick either 0 or 1!");
                }
            }
        }
    }

    public void playerInfo() {
        for (Player player : players) {
            System.out.println("Name: " + player.getName() + ", score: " + player.getScore());
        }
    }

    public void savePlayers(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("tableResults.txt"));
            for (Player player : players){
                writer.write("\nName: " + player.getName() + ", score: " + player.getScore());
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


