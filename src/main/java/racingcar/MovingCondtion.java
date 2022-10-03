package racingcar;

public class MovingCondtion {
    public static final int MOVABLE_MIN_VALUE = 4;

    public static boolean isMove(int value) {
        return value >= MOVABLE_MIN_VALUE;
    }
}
