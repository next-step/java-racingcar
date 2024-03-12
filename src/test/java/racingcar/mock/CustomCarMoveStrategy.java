package racingcar.mock;

import racingcar.domain.CarMoveStrategy;

public class CustomCarMoveStrategy implements CarMoveStrategy {

    private final String status;

    public CustomCarMoveStrategy(String status) {
        this.status = status;
    }

    @Override
    public boolean isMovable() {
        return this.status.equals("MOVE");
    }
}
