package pl.edu.model;

import java.util.Scanner;

public class Player {
    private String name;

    public Player() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your name: ");
        this.name = scanner.next();
    }

    public String getName(){
        return name;
    }




}
