package racing.controller;

import org.apache.commons.lang3.StringUtils;
import racing.domain.RacingCars;
import racing.domain.RacingGameResult;
import racing.util.Dice;

public class RacingGame {
    private static final int MIN_SETTING_NUMBER = 1;
    private final int round;
    private final RacingCars racingCars;

    public RacingGame(String carNames, int round) {
        validateParameters(carNames, round);
        this.round = round;
        this.racingCars = new RacingCars(carNames);
    }

    public RacingGameResult playGame() {
        RacingGameResult racingGameResult = new RacingGameResult();

        for (int i = 0; i < round; i++) {
            racingCars.carsMove(Dice.castByCarCount(racingCars.getJoinedCarCount()));
            racingGameResult.addResult(racingCars);
        }

        return racingGameResult;
    }

    private void validateParameters(String carNames, int round) {
        if (StringUtils.isBlank(carNames) || round < MIN_SETTING_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
