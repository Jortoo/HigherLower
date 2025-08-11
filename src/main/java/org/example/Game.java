package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Game {


    public static void playGame() {

        int highScore = YmlHandler.getStat("highscore", 1000000);

        Scanner scanner = new Scanner(System.in);

        int number = (int) (Math.random() * 101);
        int tries = 1;

        System.out.println("(Try 1) Guess the right number: (1 - 100)\n");
        int inputNumber = scanner.nextInt();

        while (number != inputNumber) {

            tries ++;

            if (number > inputNumber) {

                System.out.println("The number is higher than: " + inputNumber);

            } else {

                System.out.println("The number is lower than: " + inputNumber);

            }

            System.out.println("(Try: " + tries + ")\nGuess again\n");
            inputNumber = scanner.nextInt();

        }

        System.out.println("Correct number is: " + inputNumber + "\nTries: " + tries);

        if (highScore > tries) {
            System.out.println("Highscore beaten");
            try {
                YmlHandler.putYmlData("highscore", tries);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {

            int totalGames = YmlHandler.getStat("Total-games", 0);
            int finalTotalGames = totalGames + 1;

            YmlHandler.putYmlData("Total-games", finalTotalGames);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Main.initHL();

    }

}
