package pl.edu.model;

import java.util.Scanner;

public class Menu {

    public int showMenu(){
        System.out.println("----------- Menu -----------");
        System.out.println("0. Exit");
        System.out.println("1. Start new game");
        System.out.println("----------------------------");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }
}

