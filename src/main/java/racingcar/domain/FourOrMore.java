package racingcar.domain;

public class FourOrMore implements MoveStrategy {
    public static final int FORWARD_VALUE = 4;

    private final RandomHolder randomHolder;

    public FourOrMore(final RandomHolder randomHolder) {
        this.randomHolder = randomHolder;
    }

    @Override
    public boolean isMovable() {
        return randomHolder.getNumber() >= FORWARD_VALUE;
    }
}
