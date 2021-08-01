package racingcar.domain;

import racingcar.utils.RandomGenerate;

public class RacingMoveStrategy implements MoveStrategy {

    private final int MORE_THEN_CONDITION_NUMBER = 4;

    public RacingMoveStrategy() {
    }

    @Override
    public boolean isMoveAble() {
        return RandomGenerate.pickRandomNumber() > MORE_THEN_CONDITION_NUMBER;
    }
}