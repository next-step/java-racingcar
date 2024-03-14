package racingcar.mock;

import racingcar.domain.CarMoveStrategy;

public class AlwaysMoveStrategy implements CarMoveStrategy {
    @Override
    public boolean isMovable() {
        return true;
    }
}
