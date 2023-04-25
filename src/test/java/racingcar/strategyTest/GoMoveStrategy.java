package racingcar.strategyTest;

import racingcar.strategy.MoveStrategy;

public class GoMoveStrategy implements MoveStrategy {

    @Override
    public boolean decideMoveOrHold() {
        return true;
    }
}
