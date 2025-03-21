package controller;

import domain.Cars;
import view.InputView;
import view.ResultView;

public class RacingGame {
    private final Cars cars;
    private final int numberOfRounds;

    public RacingGame(int numberOfCars, int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        this.cars = new Cars(numberOfCars);
    }

    private void runOneRound() {
        this.cars.randomMove();
        this.cars.printCurrentPositions();
        ResultView.printResult("");
    }

    private void run() {
        ResultView.printResult("실행 결과");
        for (int i = 0; i < this.numberOfRounds; i++) {
            runOneRound();
        }
    }

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int numberOfRounds = InputView.getNumberOfRounds();

        RacingGame game = new RacingGame(numberOfCars, numberOfRounds);
        game.run();
    }
}
