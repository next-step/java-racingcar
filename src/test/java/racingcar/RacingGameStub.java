package racingcar;

import racingcar.model.Rule;
import racingcar.service.RacingGame;

import java.util.List;

public class RacingGameStub extends RacingGame {

    public RacingGameStub(List<String> racingCarNameList, int racingCount) {
        super(racingCarNameList, racingCount);
    }

    @Override
    public Rule adjustRule() {
        return () -> true;
    }

}
