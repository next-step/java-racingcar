package com.seok.racing;

public class RacingGameMain {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(RacingGameInputView.getNumberOfCars(), RacingGameInputView.getNumberOfAttempts());
        game.start();
        RacingGameOutputView.printRecords(game.getRecords());
    }
}
