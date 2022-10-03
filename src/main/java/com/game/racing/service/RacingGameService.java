package com.game.racing.service;

import com.game.racing.domain.car.Car;
import com.game.racing.domain.car.Cars;
import com.game.racing.domain.generator.NumberGenerator;
import com.game.racing.domain.generator.RandomNumberGenerator;
import com.game.racing.view.ResultView;

public class RacingGameService {

    public static final Integer MIN_VALUE_TO_MOVE_CAR = 4;

    private final Cars cars;
    private final Integer tryCount;
    private final NumberGenerator numberGenerator;

    public RacingGameService(String[] carNames, Integer tryCount) {
        this(carNames, tryCount, new RandomNumberGenerator());
    }

    public RacingGameService(String[] carNames, Integer tryCount, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.cars = new Cars(carNames);
        this.tryCount = tryCount;
    }

    public void playRacingGame() {
        moveCarsByTryCountAndGetCars();
        ResultView.printWinner(cars.getRacingWinners());
    }

    public Cars moveCarsByTryCountAndGetCars() {
        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars.getRacingCars()) {
                moveCarByGeneratedValue(car);
            }
            ResultView.printNewLine();
        }
        return cars;
    }

    private void moveCarByGeneratedValue(Car car) {
        if (numberGenerator.generate() >= MIN_VALUE_TO_MOVE_CAR) {
            car.move();
        }
        ResultView.printCarNameAndPosition(car);
    }

    public Cars getCars() {
        return cars;
    }
}
