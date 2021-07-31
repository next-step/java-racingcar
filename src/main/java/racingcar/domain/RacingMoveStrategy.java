package racingcar.domain;

public class RacingMoveStrategy implements MoveStrategy {

    private final int MORE_THEN_CONDITION_NUMBER = 4;

    public RacingMoveStrategy() {
    }

    @Override
    public boolean isMoveAble(int bound) {
        return bound >= MORE_THEN_CONDITION_NUMBER;
    }
}