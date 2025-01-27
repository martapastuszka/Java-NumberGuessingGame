package pl.edu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerManager {
    private int playerScore;

    private List<Player> players = new ArrayList<>();

    public String createPlayer() {

        Player newPlayer = new Player();
        players.add(newPlayer);

        System.out.println("Success! New player added.");

        return newPlayer.getName();
    }

    public void playerInfo() {
        for (Player player : players) {
            System.out.println("Name: " + player.getName() + ", score: " + getPlayerScore());
        }
    }

    public int setPlayerGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a number range from 1-10: ");

        return scanner.nextInt();
    }

    public int getPlayerScore(){
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}
