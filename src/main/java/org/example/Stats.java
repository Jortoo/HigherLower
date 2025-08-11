package org.example;

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

}
