package controller;

import domain.Car;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int numberOfRounds;

    public RacingGame(int numberOfCars, int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        generateCars(numberOfCars);
    }

    private void generateCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    private void runOneRound() {
        for (Car car : cars) {
            car.run();
        }
    }

    private void run() {
        ResultView.printResult("실행 결과");
        for (int i = 0; i < numberOfRounds; i++) {
            runOneRound();
            ResultView.printResult("");
        }
    }

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int numberOfRounds = InputView.getNumberOfRounds();

        RacingGame game = new RacingGame(numberOfCars, numberOfRounds);
        game.run();
    }
}
