package com.seok.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static GameResult start(Racers racers, Trials trials) {
        List<Records> result = new ArrayList<>();
        Cars cars = racers.ready();
        while (!trials.isEnd()) {
            result.add(cars.move());
            trials.attempt();
        }
        return new GameResult(cars.getWinners(), new RacingResult(result));
    }

}
