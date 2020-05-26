package racing.controller;

import racing.domain.RacingCars;
import racing.domain.RacingGameResult;

import java.util.List;

public class RacingGame {
    private static final int MIN_SETTING_NUMBER = 1;
    private final int round;
    private final RacingCars racingCars;
    private final RacingGameResult racingGameResult;

    public RacingGame(int carCount, int round) {
        validation(carCount, round);
        this.round = round;
        this.racingCars = new RacingCars(carCount);
        this.racingGameResult = new RacingGameResult();
    }

    private void validation(int carCount, int round) {
        if (carCount < MIN_SETTING_NUMBER || round < MIN_SETTING_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public RacingGameResult playGame() {
        for (int i = 0; i < round; i++) {
            List<Integer> carPositionList = racingCars.carsMove();
            racingGameResult.addResult(carPositionList);
        }

        return racingGameResult;
    }
}
