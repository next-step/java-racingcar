package racingcar;

public class FourOrMore implements MoveStrategy {
    public static final int FORWARD_VALUE = 4;

    private final RandomHolder randomHolder;

    public FourOrMore(RandomHolder randomHolder) {
        this.randomHolder = randomHolder;
    }

    @Override
    public boolean isMove() {
        return randomHolder.getNumber() >= FORWARD_VALUE;
    }
}
