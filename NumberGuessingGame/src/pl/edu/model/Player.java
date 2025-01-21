package pl.edu.model;

import java.util.Scanner;

public class Player {

    // Podawanie imienia przed nową rundą:
    private String name;
    private int playerGuess;

    public int getPlayerGuess(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a number range from 1-10: ");

        return scanner.nextInt();
    }

}
