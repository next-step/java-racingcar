package com.racingcar.service;

import com.racingcar.model.RacingCarGame;

public class RacingGameFactory {

    public RacingCarGame racingGame(Integer countOfCar, Integer countOfAttempt) {
        return new RacingCarGame(countOfCar, countOfAttempt);
    }
}
