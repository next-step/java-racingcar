package racingCar.domain.validator;

public class TryCountValidator {
    public static void validate(int tryCount) {
        validateRange(tryCount);
    }

    private static void validateRange(int tryCount) {
        if (!isInRagne(tryCount)) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }
    }

    private static boolean isInRagne(int tryCount) {
        return tryCount >= 1;
    }
}
