package com.game.racing.play;

import com.game.racing.generator.RandomIntegerGenerator;
import com.game.racing.view.ResultView;
import com.game.racing.car.Cars;

public class RacingGame {

    public void playRacingGame(Integer carCount, Integer tryCount) {
        Cars cars = new Cars(carCount, new RandomIntegerGenerator());
        moveCarsByTryCount(cars, tryCount);
    }

    public void moveCarsByTryCount(Cars cars, Integer tryCount) {
        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            System.out.println();
        }
    }

}