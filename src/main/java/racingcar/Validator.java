package racingcar;

public class Validator {

    private static final int LOW_LIMIT_COUNT = 1;

    private Validator() {
    }

    public static void validateCarAmount(int carAmount) {
        if (carAmount < LOW_LIMIT_COUNT) {
            throw new IllegalArgumentException("자동차 대수는 1 이상이어야 합니다.");
        }
    }

    public static void validateTryAmount(int tryAmount) {
        if (tryAmount < LOW_LIMIT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
