package racingCarGame.domain;

import racingCarGame.domain.MoveStrategy;

public class NotMoveStrategy implements MoveStrategy {
    @Override
    public boolean isCanMove() {
        return false;
    }
}
