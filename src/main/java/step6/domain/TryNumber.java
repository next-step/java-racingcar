package step6.domain;

public class TryNumber {
    private static final String MIN_TRY_NUMBER_ERROR_MESSAGE = "시도 회수는 1회 이상이어야 합니다.";
    private static final int MIN_TRY_NUMBER = 1;
    private int tryNumber;

    public TryNumber(int tryNumber) {
        validTryNumber(tryNumber);
        this.tryNumber = tryNumber;
    }

    private void validTryNumber(int tryNumber) {
        if (tryNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException(MIN_TRY_NUMBER_ERROR_MESSAGE);
        }
    }
}
