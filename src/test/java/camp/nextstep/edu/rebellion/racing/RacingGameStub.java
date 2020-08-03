package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;

public class RacingGameStub extends RacingGame {

    public RacingGameStub(String cars, int rounds) {
        super(cars, rounds);
    }

    @Override
    public RacingRule applyRule() {
        return () -> true;
    }
}
