package main;

import java.util.Random;
import java.util.Scanner;

public class Task {

    private PairStringInterval difficult;
    private int secretNumber;

    public void startGame() throws Exception {
        System.out.println("Game starts in:");
        for (int i = 3; i > 0; i--) {
            System.out.println(i + "...");
            Thread.sleep(1000);
        }
    }

    public void chooseDifficult() {
        System.out.println("Choose difficult (1 - easy, 2 - medium, 3 - hard)");
        Scanner scanner = new Scanner(System.in);
        while (difficult == null) {
            int inputDifficult = scanner.nextInt();
            switch (inputDifficult) {
                case 1:
                    difficult = new PairStringInterval("Easy", new PairInt(1, 10));
                    break;
                case 2:
                    difficult = new PairStringInterval("Medium", new PairInt(1, 100));
                    break;
                case 3:
                    difficult = new PairStringInterval("Hard", new PairInt(1, 1000));
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
        System.out.println("You choose " + difficult.first + " difficult...");
    }

    public void randomNumberGenerator() {
        if (difficult == null) {
            System.out.println("Error! You have not selected a difficulty level!");
            return;
        }
        int min = difficult.second.first;
        int max = difficult.second.second;
        int distinction = max - min;
        Random random = new Random();
        secretNumber = min + random.nextInt(distinction + 1);
        System.out.println("Number generated successfully!");
    }

    public void gameProcess() {
        if (difficult == null || secretNumber < difficult.second.first || secretNumber > difficult.second.second) {
            System.out.println("Error! You have not selected a difficulty level or an error occurred while generating the number");
            return;
        }
        int userAttempt = 0;
        while (userAttempt != secretNumber) {
            System.out.println("Insert the number");
            Scanner scanner = new Scanner(System.in);
            userAttempt = scanner.nextInt();
            if (userAttempt < secretNumber) {
                System.out.println("Your number is less");
            }else if(userAttempt > secretNumber){
                System.out.println("Your number is greater");
            }else{
                System.out.println("Congratulations! \nYou guessed. \nConceived number: " + secretNumber);
                return;
            }
        }

    }
}
