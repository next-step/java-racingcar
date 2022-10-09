package racingcar.backend.controller;

import racingcar.backend.domain.*;
import racingcar.backend.service.PlayService;
import racingcar.backend.strategy.RandomMoveStrategy;

public class RacingCarGameController {

    private static final String COMMA = ",";
    private final Cars cars;
    private final int times;

    public RacingCarGameController(String names, int times) {
        this.cars = Cars.create(names.split(COMMA));
        this.times = times;
    }

    public GameRecords start() {
        GameRecords gameRecords = GameRecords.create();
        for (int i = 0; i < times; i++) {
            Cars cars = PlayService.playCar(this.cars, new RandomMoveStrategy());
            gameRecords.add(PlayService.getGameRecord(cars));
        }
        return gameRecords;
    }
}
