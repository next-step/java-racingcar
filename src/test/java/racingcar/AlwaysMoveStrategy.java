package racingcar;

import racingcar.domain.MoveStrategy;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMovable() {
        return true;
    }
}
