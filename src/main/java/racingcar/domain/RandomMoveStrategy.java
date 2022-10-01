package racingcar.domain;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVING_CONDITION_MIN_VALUE = 4;
    private int randomNumber;

    public RandomMoveStrategy(int value) {
        this.randomNumber = value;
    }

    @Override
    public boolean movable() {
        return MOVING_CONDITION_MIN_VALUE <= randomNumber;
    }
}
