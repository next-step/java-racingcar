package racingcar;

public class FourOrMore implements MoveStrategy {
    public static final int FORWARD_VALUE = 4;

    @Override
    public boolean isForward(int number) {
        return number >= FORWARD_VALUE;
    }
}
