package racingcar;

public class RacingCarMovableStrategy implements MovableStrategy {

    private static final int MOVE_CONDITION = 4;

    public boolean isMovable(int value) {
        return value >= MOVE_CONDITION;
    }

}
