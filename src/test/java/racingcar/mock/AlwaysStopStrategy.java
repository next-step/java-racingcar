package racingcar.mock;

import racingcar.domain.CarMoveStrategy;

public class AlwaysStopStrategy implements CarMoveStrategy {
    @Override
    public boolean isMovable() {
        return false;
    }
}
