package racingcar.domain.random;

public class NoMoveGen implements RandomStrategy {

    public static final int NOMOVE = 3;

    @Override
    public int get() {
        return NOMOVE;
    }
}
