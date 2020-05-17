package racingcar.domain.car.strategy;

import java.util.List;

public class FixedMovementStrategy implements MovementStrategy {

    public static final boolean MOVE = true;
    public static final boolean STOP = false;
    private static final int FIRST_ELEMENT = 0;
    private List<Boolean> movables;

    public FixedMovementStrategy(List<Boolean> movables) {
        this.movables = movables;
    }

    @Override
    public boolean isMovable() {
        boolean movable = movables.get(FIRST_ELEMENT);
        movables.remove(FIRST_ELEMENT);
        return movable;
    }
}
