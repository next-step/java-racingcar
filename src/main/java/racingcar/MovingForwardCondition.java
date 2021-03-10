package racingcar;

public class MovingForwardCondition {
    public static final int THRESHOLD = 4;

    static boolean isSatisfied(int value) {
        return value >= THRESHOLD;
    }
}
