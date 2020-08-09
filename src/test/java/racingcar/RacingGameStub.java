package racingcar;

import racingcar.model.Rule;
import racingcar.service.RacingGame;

import java.util.List;

public class RacingGameStub extends RacingGame {

    public RacingGameStub(List<String> racingCarNames, int racingCount) {
        super(racingCarNames, racingCount);
    }

    @Override
    public Rule adjustRule() {
        return () -> true;
    }

}
