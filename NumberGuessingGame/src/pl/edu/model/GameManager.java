package pl.edu.model;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;


// wczytywać z pliku 5 najlepszych graczy
// number of attempts - nie może się zmniejszać gdy podamy liczbę inną niz z zadanego przedziału
// sprawdzić słowniki i tablice asocjacyjne

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
//                    playerInfo();
                    List<Map.Entry<String, Integer>> entryList = savePlayers();
                    showBestPlayers();
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

//    public void savePlayers(){
//        try{
//            BufferedWriter writer = new BufferedWriter(new FileWriter("tableResults.txt"));
//            for (Player player : players){
//                writer.write("\nName: " + player.getName() + ", score: " + player.getScore());
//            }
//            writer.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//}

    public List<Map.Entry<String, Integer>> savePlayers() {
        Map<String, Integer> map = new HashMap<>();

        for (Player player : players) {
            String name = player.getName();
            int score = player.getScore();
            // sprawdzam czy klucz juz istnieje
            if (map.containsKey(name)) {
                //dodaję nową wartość do istniejącej
                map.put(name, map.get(name) + score);
            } else {
                map.put(player.getName(), player.getScore());
            }
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("tableResults.txt"));
            for (Map.Entry<String, Integer> entry : entryList) {
                writer.write("\nName: " + entry.getKey() + ", score: " + entry.getValue());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entryList;
    }

//    public List<Map.Entry<String, Integer>> savePlayers() {
//        Map<String, Integer> map = new HashMap<>();
//
//        for (Player player : players) {
//            String name = player.getName();
//            int score = player.getScore();
//            // sprawdzam czy klucz juz istnieje
//            if (map.containsKey(name)) {
//                //dodaję nową wartość do istniejącej
//                map.put(name, map.get(name) + score);
//            } else {
//                map.put(player.getName(), player.getScore());
//            }
//        }
//        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
//        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("tableResults.txt"));
//            for (Map.Entry<String, Integer> entry : entryList) {
//                writer.write("\nName: " + entry.getKey() + ", score: " + entry.getValue());
//            }
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return entryList;
//    }

    public void showBestPlayers(){
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("tableResults.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                if(!line.trim().isEmpty()){
                    String[] parts = line.split(", ");
                    String name = parts[0].substring(parts[0].indexOf(":") + 2);
                    int score = Integer.parseInt(parts[1].substring(parts[1].indexOf(": ")+2));
                    entryList.add(new AbstractMap.SimpleEntry<>(name, score));

                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        // Sortujemy listę wpisów w kolejności malejącej według wartości
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Tworzymy listę, aby zapisać wyniki najlepszych graczy
        List<Map.Entry<String, Integer>> bestPlayers = new ArrayList<>();

        int maxResults = 3;
        int currentBestScore = entryList.get(0).getValue();

        for (Map.Entry<String, Integer> entry : entryList) {
            if (bestPlayers.size() < maxResults || entry.getValue().equals(currentBestScore)) {
                bestPlayers.add(entry);
                currentBestScore = entry.getValue();
            } else {
                break;
            }
        }

        // Wyświetlamy najlepszych graczy
        for (Map.Entry<String, Integer> entry : bestPlayers) {
            System.out.println("Player: " + entry.getKey() + ", Score: " + entry.getValue());
        }
    }

//    public void showBestPlayers(List<Map.Entry<String, Integer>> entryList) {
//        System.out.println("------- Best results -------");
//        //Sortowanie listy wpisów w kolejności malejącej według wartości
////        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
//
//        //Tworzymy listę aby zapisać wyniki najlepszych graczy
//        List<Map.Entry<String, Integer>> bestPlayers = new ArrayList<>();
//
//        int maxResults = 3;
//        int currentBestScore = entryList.get(0).getValue();
//
//
//
//        for(Map.Entry<String, Integer> entry : entryList){
//            if(bestPlayers.size() < maxResults || entry.getValue().equals(currentBestScore)){
//                bestPlayers.add(entry);
//                currentBestScore = entry.getValue();
//            }else{
//                break;
//            }
//        }
//
//        //Wyswietlamy 3 najlepsze wyniki
//        for(Map.Entry<String, Integer> entry : bestPlayers){
////            System.out.println("Player: " + entry.getKey() + ", Score: " + entry.getValue());
//            try (BufferedReader reader = new BufferedReader(new FileReader("tableResults.txt"))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    System.out.println(line);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }

//        try (BufferedReader reader = new BufferedReader(new FileReader("tableResults.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


////    public void showBestPlayers(List<Map.Entry<String, Integer>> entryList) {
////        System.out.println("------- Best results -------");
////        try {
////            BufferedReader reader = new BufferedReader(new FileReader("tableResults.txt"));
////            String line = reader.readLine();
////            int i;
////            int counter = 0;
////            int index = 0;
////            while (((line = reader.readLine()) != null) && counter != 3) {
////                for (i = 0; i < entryList.size(); i++) {
////                    Map.Entry<String, Integer> entry = entryList.get(i);
//////                    Map.Entry<String, Integer> entry0 = entryList.get(0);
////                    Integer value = entry.getValue();
////                    if (index == 0) {
////                        System.out.println(line);
////                        index++;
////                    }else if (index > 0 && entry.getValue() == entry.getValue(0));
////                        System.out.println(line);
////
////                    if ()  {
////                        if(entry.getValue() )
////                        System.out.println(line);
////                        counter++;
////                    } else if (i++ == i) {
////                        System.out.println(line);
////                    }
////                }
////            }
//
////            while (((line = reader.readLine()) != null) && counter != 3) {
////                System.out.println(line);
////                counter++;
////            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }



