package racingcar.domain;

import racingcar.domain.strategy.RandomMovingStrategy;

public class RacingGameController {

    private static final RacingGameController GAME_CONTROLLER = new RacingGameController();

    private RacingGameController() {
    }

    public static RacingGameController getInstance() {
        return GAME_CONTROLLER;
    }

    public Records execute(int counts, int laps) {
        RacingCars racingCars = RacingCars.from(counts, RandomMovingStrategy.getInstance());
        Records records = Records.EMPTY_RECORDS;

        for (int i = 1; i <= laps; i++) {
            racingCars = racingCars.race();
            records = records.record(Lap.from(i), Record.from(racingCars));
        }

        return records;
    }
}
