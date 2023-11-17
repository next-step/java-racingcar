package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import camp.nextstep.edu.racingcar.domain.result.RacingGameResult;
import camp.nextstep.edu.racingcar.domain.result.RoundResult;

public class RacingGame {

    public static final String CAR_NAME_DELIMITER = ",";
    private final int roundAmount;
    private final Cars cars;

    public RacingGame(DriveStrategy driveStrategy, String carNames, int roundAmount) {
        this.roundAmount = roundAmount;
        this.cars = new Cars(driveStrategy, carNames.split(CAR_NAME_DELIMITER));
    }

    public RacingGameResult play() {
        RacingGameResult racingGameResult = new RacingGameResult();

        for (int i = 0; i < roundAmount; i++) {
            RoundResult roundResult = cars.drive();
            racingGameResult.report(roundResult);
        }
        return racingGameResult;
    }
}
