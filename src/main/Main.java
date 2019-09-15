package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int exit = 1;
        while(exit == 1) {
            Task task = new Task();
            task.startGame();
            task.chooseDifficult();
            task.randomNumberGenerator();
            task.gameProcess();
            System.out.println("Play again? 1 - YES! 0 - No, I'm a boring poodle");
            Scanner scanner = new Scanner(System.in);
            exit = scanner.nextInt();
        }
    }
}
