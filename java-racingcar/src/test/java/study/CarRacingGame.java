package study;


import ui.InputView;

public class CarRacingGame {
    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int rounds = InputView.getNumberOfRounds();
        RacingGame game = new RacingGame(numberOfCars, rounds);
        game.start();
    }
}