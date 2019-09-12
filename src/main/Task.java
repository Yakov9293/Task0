package main;

import java.util.Scanner;

public class Task {

    private PairStringInterval difficult;

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
}
