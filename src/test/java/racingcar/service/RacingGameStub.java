package racingcar.service;

import racingcar.domain.Rule;
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
