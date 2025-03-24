package controller;

import domain.Cars;
import domain.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class RacingGame {
    private final Cars cars;
    private final int numberOfRounds;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public RacingGame(int numberOfCars, int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        this.cars = new Cars(numberOfCars);
    }

    private void runOneRound() {
        this.cars.move(randomNumberGenerator);
        // this.cars.printCurrentPositions();
        ResultView.printCurrentPositions(this.cars.getCurrentPositions());
        ResultView.printMessage("");
    }

    private void run() {
        ResultView.printMessage("실행 결과");
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
