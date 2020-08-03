package camp.nextstep.edu.rebellion.racing.stub;

import camp.nextstep.edu.rebellion.racing.domain.RacingGame;
import camp.nextstep.edu.rebellion.racing.rule.RacingRule;

import java.util.List;

public class RacingGameStub extends RacingGame {

    public RacingGameStub(List<String> cars, int rounds) {
        super(cars, rounds);
    }

    @Override
    public RacingRule applyRule() {
        return () -> true;
    }
}
