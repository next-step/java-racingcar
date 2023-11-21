package racingCar.domain.validator;

public class TryCountValidator {
    public static final int MIN_TRY_COUNT = 1;

    private TryCountValidator() {
    }

    public static void validate(int tryCount) {
        validateRange(tryCount);
    }

    private static void validateRange(int tryCount) {
        if (!isInRagne(tryCount)) {
            throw new IllegalArgumentException(String.format("시도 횟수는 %d이상이어야 합니다.", MIN_TRY_COUNT));
        }
    }

    private static boolean isInRagne(int tryCount) {
        return tryCount >= MIN_TRY_COUNT;
    }
}
