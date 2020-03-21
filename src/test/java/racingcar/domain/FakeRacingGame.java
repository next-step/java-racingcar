package racingcar.domain;

import racingcar.Constant;

public class FakeRacingGame implements RacingGameRule {

    @Override
    public boolean isForward(int condition) {
        return condition >= Constant.APPROVE_CONDITION;
    }
}
