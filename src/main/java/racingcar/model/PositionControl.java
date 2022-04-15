package racingcar.model;

public class PositionControl implements MovingStrategy {
    private static final int RANDOM_MINIMUM_VALUE_CAN_BE_MOVED = 4;

    @Override
    public boolean matchMovementCondition(int value) {
        return value >= RANDOM_MINIMUM_VALUE_CAN_BE_MOVED;
    }
}
