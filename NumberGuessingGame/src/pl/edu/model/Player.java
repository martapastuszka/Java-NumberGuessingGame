package pl.edu.model;

import java.util.Scanner;

public class Player {
    private String name;

    private int score;

    public Player() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your name: ");
        this.name = scanner.next();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;

    }

}
