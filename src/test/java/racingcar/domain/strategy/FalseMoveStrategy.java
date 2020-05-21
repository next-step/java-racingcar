package racingcar.domain.strategy;

import racingcar.domain.MoveStrategy;

public class FalseMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return false;
    }
}
