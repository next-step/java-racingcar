package util;

public class RacingValidator {

    private static final int MOVE_FORWARD_CONDITION_NUMBER = 4;

    public static boolean isMovable(Integer intNumber) {
        return intNumber >= MOVE_FORWARD_CONDITION_NUMBER;
    }
}
