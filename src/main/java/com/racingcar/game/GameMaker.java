package com.racingcar.game;

import com.racingcar.game.car.Car;
import com.racingcar.view.model.GameInputDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameMaker {
    public static RacingGame make(GameInputDto input) {
        return new RacingGame(input.getGameRound(), makeCars(input.getNames()));
    }

    private static List<Car> makeCars(String names) {
        return Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
