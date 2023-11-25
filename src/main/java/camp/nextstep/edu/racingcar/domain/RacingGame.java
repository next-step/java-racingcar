package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import camp.nextstep.edu.racingcar.domain.result.RacingGameResult;
import camp.nextstep.edu.racingcar.domain.result.RoundResult;

public class RacingGame {

    private final int roundAmount;
    private final Cars cars;

    public RacingGame(DriveStrategy driveStrategy, String[] carNames, int roundAmount) {
        this.roundAmount = roundAmount;
        this.cars = new Cars(driveStrategy, carNames);
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
