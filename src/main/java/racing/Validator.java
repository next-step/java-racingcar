package racing;

public class Validator {
    private static final int CAR_LOWER_BOUND = 1;
    private static final int CAR_UPPER_BOUND = 10;

    private static final int ROUND_LOWER_BOUND = 1;
    private static final int ROUND_UPPER_BOUND = 10;

    public static void validateCarCount(int carCount) {
        if (carCount < CAR_LOWER_BOUND || carCount > CAR_UPPER_BOUND) {
            throw new IllegalArgumentException("자동차 대수는 10이하의 자연수만 가능합니다.");
        }
    }

    public static void validateMoveCount(int moveCount) {
        if (moveCount < ROUND_LOWER_BOUND || moveCount > ROUND_UPPER_BOUND) {
            throw new IllegalArgumentException("이동 횟수는 10이하의 자연수만 가능합니다.");
        }
    }
}
