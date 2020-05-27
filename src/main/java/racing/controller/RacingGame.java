package racing.controller;

import org.apache.commons.lang3.StringUtils;
import racing.domain.RacingCars;
import racing.domain.RacingGameResult;

public class RacingGame {
    private static final int MIN_SETTING_NUMBER = 1;
    private final int round;
    private final RacingCars racingCars;
    private final RacingGameResult racingGameResult;

    public RacingGame(String carNames, int round) {
        validation(carNames, round);
        this.round = round;
        this.racingCars = new RacingCars(carNames.split(","));
        this.racingGameResult = new RacingGameResult();
    }

    private void validation(String carNames, int round) {
        if (StringUtils.isBlank(carNames) || round < MIN_SETTING_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public RacingGameResult playGame() {
        for (int i = 0; i < round; i++) {
            racingCars.carsMove();
            racingGameResult.addResult(racingCars);
        }

        return racingGameResult;
    }
}
