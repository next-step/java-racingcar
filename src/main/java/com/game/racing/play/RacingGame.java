package com.game.racing.play;

import com.game.racing.car.Winner;
import com.game.racing.generator.RandomNumberGenerator;
import com.game.racing.view.ResultView;
import com.game.racing.car.Cars;

public class RacingGame {

    public void play(String carNames, Integer tryCount) {
        Cars cars = new Cars(carNames, new RandomNumberGenerator());
        moveCarsByTryCount(cars, tryCount);
    }

    public void moveCarsByTryCount(Cars cars, Integer tryCount) {
        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
        }
        ResultView.printWinner(Winner.getRacingWinners(cars));
    }

}