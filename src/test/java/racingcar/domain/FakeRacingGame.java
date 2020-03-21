package racingcar.domain;

public class FakeRacingGame implements RacingGameRule {

    @Override
    public boolean isForward(int condition) {
        return condition >= RacingGameConstant.APPROVE_CONDITION;
    }
}
