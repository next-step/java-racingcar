package racingcar.domain.strategy;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVE_LOWER_BOUND = 4;

    @Override
    public boolean canMove(int number) {
        return MOVE_LOWER_BOUND <= number;
    }
}
