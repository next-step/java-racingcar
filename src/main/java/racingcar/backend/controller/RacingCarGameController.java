package racingcar.backend.controller;

import racingcar.backend.domain.Cars;
import racingcar.backend.domain.GameRecords;
import racingcar.backend.service.PlayService;

public class RacingCarGameController {

    private static final String COMMA = ",";
    private final Cars cars;
    private final int times;

    public RacingCarGameController(String names, int times) {
        this.cars = Cars.create(names.split(COMMA));
        this.times = times;
    }

    public GameRecords start() {
        return new PlayService().play(cars, times);
    }
}
