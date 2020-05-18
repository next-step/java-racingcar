package com.racingcar.service;

import com.racingcar.model.RacingCarGame;

import java.util.List;

public class RacingCarGameFactory {

    public RacingCarGame racingGame(List<String> racingCarNames, Integer countOfAttempt) {
        return new RacingCarGame(racingCarNames, countOfAttempt);
    }
}
