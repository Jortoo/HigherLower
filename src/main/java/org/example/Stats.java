package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Stats {

    public static int defaultHighscoreValue = 1000000;

    public static void seeStats() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Your stats:\n - Least amount of guesses: " + YmlHandler.getStat("highscore", defaultHighscoreValue)
                + "\n - Total games: "
                + YmlHandler.getStat("Total-games", 0)
                + "\n\n Type '1' to go back");

        int choice = scanner.nextInt();

        while (choice != 1) {
            System.out.println("Unknown choice.");
            choice = scanner.nextInt();
        }

        Main.initHL();

    }

    public static void setHighscore(int tries) {

        try {
            YmlHandler.putYmlData("highscore", tries);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void setTotalGames() {

        try {

            int totalGames = YmlHandler.getStat("Total-games", 0);
            int finalTotalGames = totalGames + 1;

            YmlHandler.putYmlData("Total-games", finalTotalGames);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
