package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        initHL();

    }

    public static void initHL() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?\n1. Play the game\n2. See your statistics\n3. Close menu");

        int menuChoice = scanner.nextInt();

        menuFunctionality(menuChoice);

    }

    private static void menuFunctionality(int choice) {

        switch (choice) {

            case 1 -> Game.playGame();

            case 2 -> Stats.seeStats();

            case 3 -> System.exit(1);

        }

    }

}