package racingcar.domain;

public class RandomMoveCondition implements MoveCondition {
    private static final int MINIMUM_OF_MOVE = 4;

    @Override
    public boolean isMovable(int num) {
        return num >= MINIMUM_OF_MOVE;
    }
}
