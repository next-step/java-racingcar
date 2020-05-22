package racingcar.domain.strategy;

import racingcar.domain.MoveStrategy;

public class TrueMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return true;
    }
}
