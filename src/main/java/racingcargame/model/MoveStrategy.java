package racingcargame.model;

public class MoveStrategy {
    private static final int MOVING_CONDITION = 4;

    public boolean isMovable(int number) {
        return number >= MOVING_CONDITION;
    }
}
