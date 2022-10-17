package racingcar.backend.controller;

import racingcar.backend.converter.GameRecordConverter;
import racingcar.backend.domain.Cars;
import racingcar.backend.domain.GameRecords;
import racingcar.backend.strategy.MoveStrategy;

public class RacingCarGameController {

    private static final String COMMA = ",";
    private final Cars cars;
    private final int times;

    public RacingCarGameController(String names, int times) {
        this.cars = Cars.create(names.split(COMMA));
        this.times = times;
    }

    public GameRecords start(MoveStrategy moveStrategy) {
        GameRecords gameRecords = new GameRecords();
        for (int i = 0; i < times; i++) {
            Cars cars = this.cars.move(moveStrategy);
            gameRecords.add(GameRecordConverter.getGameRecord(cars));
        }
        return gameRecords;
    }
}
