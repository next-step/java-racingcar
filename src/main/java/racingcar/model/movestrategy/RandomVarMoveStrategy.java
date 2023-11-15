package racingcar.model.movestrategy;

import racingcar.model.movestrategy.MoveStrategy;

public class RandomVarMoveStrategy implements MoveStrategy {
    private static final int THRESHOLD_NUMBER = 4;

    @Override
    public boolean canMove(int value) {
        return value >= THRESHOLD_NUMBER;
    }
}
