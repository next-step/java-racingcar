package com.game.racing.play;

import com.game.racing.generator.RandomNumberGenerator;
import com.game.racing.view.ResultView;
import com.game.racing.car.Cars;

public class RacingGame {

    public void play(Integer carCount, Integer tryCount) {
        Cars cars = new Cars(carCount, new RandomNumberGenerator());
        moveCarsByTryCount(cars, tryCount);
    }

    public void moveCarsByTryCount(Cars cars, Integer tryCount) {
        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
        }
    }

}