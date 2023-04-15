package study.racingcar.strategy;

public class NonMovableNumberGenerator implements NumberGenerator{
    public static final int NON_MOVABLE_UPPER_BOUND = 3;
    @Override
    public int generate() {
        return NON_MOVABLE_UPPER_BOUND;
    }
}

