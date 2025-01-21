package pl.edu;

import pl.edu.model.Game;
import pl.edu.model.MenuManager;

import java.awt.*;

public class GamePlay {

    public void start() {
        System.out.println();
        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Computer picks a number range 0-10,");
        System.out.println("Your task is guess which it picked. You have 3 attempts. Good luck!");

        MenuManager menu = new MenuManager();

        for (; ; ) {
            int o = menu.showMenu();

            switch (o) {
                case 0 -> {
                    System.out.println("Thank you bye bye!");
                    return;
                }
                case 1 -> {
                    Game game = new Game();
                    game.newGame();

                }
                default -> {
                    System.out.println("Pick either 0 or 1!");
                }
            }
        }

    }
}
