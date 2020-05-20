package com.racingcar.factory;

import com.racingcar.domain.RacingCarGame;

import java.util.List;

public class RacingCarGameFactory {

    public RacingCarGame racingGame(List<String> racingCarNames, Integer countOfAttempt) {
        return new RacingCarGame(racingCarNames, countOfAttempt);
    }
}
