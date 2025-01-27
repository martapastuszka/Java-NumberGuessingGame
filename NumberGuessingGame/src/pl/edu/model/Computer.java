package pl.edu.model;

import java.util.Random;

public class Computer {
    private String name = "Alex";

    public int generateNumber(){
        Random random = new Random();
        int randomInt = random.nextInt(11);
        System.out.println("[TEST]Computer guess: " + randomInt);

        return randomInt;
    }
}
