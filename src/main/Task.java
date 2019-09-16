package main;

import java.util.Random;
import java.util.Scanner;

public class Task {

    private PairStringInterval difficult;
    private int secretNumber;
    private GameStatus gameStatus = GameStatus.PLAYING;

    public void runGame() throws Exception {//есть ли смысл в том, чтобы сделать метод статичным?
        while (gameStatus == GameStatus.PLAYING) {
            startGame();
            chooseDifficult();
            randomNumberGenerator();
            gameProcess();
            offerToContinue();
        }
    }

    private void startGame() throws Exception {
        System.out.println("Game starts in:");
        for (int i = 3; i > 0; i--) {
            System.out.println(i + "...");
            Thread.sleep(1000);
        }
    }

    private void chooseDifficult() {
        System.out.println("Choose difficult (1 - easy, 2 - medium, 3 - hard)");
        Scanner scanner = new Scanner(System.in);
        while (difficult == null) {
            int inputDifficult = 0;
            try {
                inputDifficult = scanner.nextInt();
            } catch (Exception ex) {
                scanner.next();
            }
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

    private void randomNumberGenerator() {
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

    private void gameProcess() {
        if (difficult == null || secretNumber < difficult.second.first || secretNumber > difficult.second.second) {
            System.out.println("Error! You have not selected a difficulty level or an error occurred while generating the number");
            return;
        }
        while (true) {
            System.out.println("Insert the number");
            int userAttempt = simpleNumberEntry();//нормально ли, что я каждый раз создаю переменную. Мб инициализацию стоило вынести за цикл.
            //и нормально ли, что у меня из-за вызова метода simpleNumberEntry, кучу раз создаётся экземпляр класса Scanner
            if (userAttempt < secretNumber) {
                System.out.println("Your number is less");
            } else if (userAttempt > secretNumber) {
                System.out.println("Your number is greater");
            } else {
                System.out.println("Congratulations!\nYou guessed.\nConceived number: " + secretNumber);
                return;
            }
        }

    }

    private void offerToContinue() {
        System.out.println("Play again? Press 1 to continue. Press 0 to exit.");
        int userEnteredValue = simpleNumberEntry();
        boolean isGoodEnteredValue = userEnteredValue == 0 || userEnteredValue == 1;
        if (isGoodEnteredValue) {
            gameStatus = (userEnteredValue == 0) ? GameStatus.STOPPING : GameStatus.PLAYING;
        } else {
            offerToContinue();
        }

    }

    private int simpleNumberEntry() {//не стоило ли сделать метод с другим модификатором доступа
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Incorrect input");
        }
        return scanner.nextInt();
    }

    enum GameStatus {
        PLAYING,
        STOPPING
    }
}
