package racingcar;

public class GreaterEqualThanStrategy implements MoveStrategy {
    private static final Integer MINIMUM_NUMBER_TO_MOVE = 4;

    @Override
    public boolean isMovable(Integer number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }
}
