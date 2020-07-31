package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;

public class RacingGameStub extends RacingGame {

    public RacingGameStub(int carNumbers, int rounds) {
        super(carNumbers, rounds);
    }

    @Override
    public RacingRule applyRule() {
        return () -> true;
    }
}
