package racingcar.mock;

import racingcar.domain.CarMoveStrategy;

public class NeverMoveStrategy implements CarMoveStrategy {
    @Override
    public boolean isMovable() {
        return false;
    }
}
