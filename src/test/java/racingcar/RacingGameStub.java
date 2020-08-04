package racingcar;

import racingcar.model.Rule;
import racingcar.service.RacingGame;

public class RacingGameStub extends RacingGame {

    public RacingGameStub(int racingCarNumber, int racingCount) {
        super(racingCarNumber, racingCount);
    }

    @Override
    public Rule adjustRule() {
        return () -> true;
    }

}
