package racingcar.domain.random;

public class MoveGen implements RandomStrategy {

    private static final int MOVE = 5;

    @Override
    public int get() {
        return MOVE;
    }
}
