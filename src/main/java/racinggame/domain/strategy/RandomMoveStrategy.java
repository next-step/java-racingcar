package racinggame.domain.strategy;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int CAN_MOVE_MIN_NUMBER = 4;

    @Override
    public boolean movable(int number) {
        return number >= CAN_MOVE_MIN_NUMBER;
    }
}
