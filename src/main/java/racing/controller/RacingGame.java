package racing.controller;

import org.apache.commons.lang3.StringUtils;
import racing.domain.Cars;
import racing.domain.RacingGameResult;
import racing.util.Dice;

public class RacingGame {
    private static final int MIN_SETTING_NUMBER = 1;
    private final int round;
    private final Cars cars;

    public RacingGame(String carNames, int round) {
        validateParameters(carNames, round);
        this.round = round;
        this.cars = new Cars(carNames);
    }

    public RacingGameResult playGame() {
        RacingGameResult racingGameResult = new RacingGameResult();

        for (int i = 0; i < round; i++) {
            cars.moveCars(Dice.castByCarCount(cars.getJoinedCarCount()));
            racingGameResult.addResult(cars);
        }

        return racingGameResult;
    }

    private void validateParameters(String carNames, int round) {
        if (StringUtils.isBlank(carNames) || round < MIN_SETTING_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
