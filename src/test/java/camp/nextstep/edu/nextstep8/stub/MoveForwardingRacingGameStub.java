package camp.nextstep.edu.nextstep8.stub;

import camp.nextstep.edu.nextstep8.racing.RacingGame;
import camp.nextstep.edu.nextstep8.racing.rule.ForwardingRule;

public class MoveForwardingRacingGameStub extends RacingGame {
    public MoveForwardingRacingGameStub(String cars, int raceTimes) {
        super(cars, raceTimes);
    }

    @Override
    public ForwardingRule getRaceRule() {
        return new MoveForwardingRuleStub();
    }
}
