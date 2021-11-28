package study.racinggame.controller;

import study.racinggame.domain.car.Car;
import study.racinggame.domain.car.Cars;
import study.racinggame.domain.car.Names;
import study.racinggame.view.InputView;
import study.racinggame.view.OutputView;

import java.util.List;

public class Game {
    private final Cars cars;

    public void run() {
        start();
        finish();
    }

    public Game() {
        String carNames = InputView.getCarNames();
        cars = new Cars(new Names(carNames));
    }

    private void start() {
        int numberOfTrial = InputView.getNumberOfTrial();

        for (int i = 0; i < numberOfTrial; i++) {
            OutputView.printSeparator();
            cars.move();
            OutputView.printPosition(cars);
        }
    }

    private void finish() {
        List<Car> winners = cars.winners();
        OutputView.printWinners(winners);
    }
}
