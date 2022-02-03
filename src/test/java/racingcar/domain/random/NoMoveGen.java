package racingcar.domain.random;

public class NoMoveGen implements MovementStrategy {

    private static final int NO_MOVE = 3;

    @Override
    public int get() {
        return NO_MOVE;
    }
}
