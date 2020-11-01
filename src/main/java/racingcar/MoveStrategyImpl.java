package racingcar;

public class MoveStrategyImpl implements MoveStrategy {
    public static final int MOVEMENT_UNIT = 1;

    @Override
    public int getMovement() {
        return MOVEMENT_UNIT;
    }
}
