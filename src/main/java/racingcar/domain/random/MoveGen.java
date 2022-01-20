package racingcar.domain.random;

public class MoveGen implements RandomStrategy {

    public static final int MOVE = 5;

    @Override
    public int get() {
        return MOVE;
    }
}
