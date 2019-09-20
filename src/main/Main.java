package main;

import main.tasks.store.StoreService;

public class Main {
    public static void main(String[] args) throws Exception {
        //new GuessTheNumber().runGame();
        new StoreService().create();
    }
}

