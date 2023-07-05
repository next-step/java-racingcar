package racingcar.util;

public class RaceUtil {
    private static final String NOT_VALID_RANGE_MESSAGE = "범위 밖의 수가 입력되었습니다";
    private static final int STOP_LOWER_BOUND = 0;
    private static final int STOP_UPPER_BOUND = 3;
    private static final int MOVE_LOWER_BOUND = 4;
    private static final int MOVE_UPPER_BOUND = 9;

    public static boolean determineCarMovement(int val) {
        if (val >= STOP_LOWER_BOUND && val <= STOP_UPPER_BOUND) {
            return false;
        }

        if (val >= MOVE_LOWER_BOUND && val <= MOVE_UPPER_BOUND) {
            return true;
        }

        throw new RuntimeException(NOT_VALID_RANGE_MESSAGE);
    }
}
