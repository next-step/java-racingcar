package racingCarGame.domain;

import racingCarGame.domain.MoveStrategy;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean isCanMove() {
        return true;
    }
}
