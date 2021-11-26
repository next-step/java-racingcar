package study.racinggame.controller;

import study.racinggame.domain.car.Car;
import study.racinggame.domain.car.Cars;
import study.racinggame.view.InputView;
import study.racinggame.view.OutputView;

import java.util.List;

public class Game {
    public static final String DELIMITER = ",";
    public static final int NUMBER_OF_CARS = 3;

    private Cars cars;

    public void run() {
        setup();
        start();
        finish();
    }

    private void setup() {
        String carNames = InputView.getCarNames();
        String[] splitCarNames = split(carNames);

        cars = new Cars(splitCarNames);
    }

    private String[] split(String carNames) {
        String[] splitCarNames = carNames.split(DELIMITER);

        if (splitCarNames.length != NUMBER_OF_CARS) {
            throw new IllegalArgumentException("자동차는 3대만 입력 가능합니다.");
        }

        return splitCarNames;
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
