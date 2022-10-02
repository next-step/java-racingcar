package com.game.racing.service;

import com.game.racing.domain.car.Cars;
import com.game.racing.domain.generator.RandomNumberGenerator;
import com.game.racing.view.ResultView;

public class RacingGameService {

    private final Cars cars;
    private final Integer tryCount;

    public RacingGameService(String[] carNames, Integer tryCount) {
        this.cars = new Cars(carNames, new RandomNumberGenerator());
        this.tryCount = tryCount;
    }

    public Cars playRacingGame() {
        moveCarsByTryCount(cars, tryCount);
        return cars;
    }

    public void moveCarsByTryCount(Cars cars, Integer tryCount) {
        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
        }
    }

}
