package step3.controller;

public class CycleManager {
    private static final int MIN_ROUND = 0;
    private static final int MAX_ROUND = 10;
    private static final String CYCLE_ERROR_MESSAGE = "시도할 횟수는 0보다 커야 합니다.";

    public static void inputRoundCheck(int round) {
        if (round <= MIN_ROUND) {
            throw new IllegalArgumentException(CYCLE_ERROR_MESSAGE);
        }
    }
}
