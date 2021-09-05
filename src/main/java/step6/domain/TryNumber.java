package step6.domain;

import java.util.Objects;

public class TryNumber {
    private static final String MIN_TRY_NUMBER_ERROR_MESSAGE = "시도 회수는 1회 이상이어야 합니다.";
    private static final int FINISH_TRY_NUMBER = 0;
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

    public boolean finish() {
        return tryNumber <= FINISH_TRY_NUMBER;
    }

    public void minus() {
        tryNumber--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryNumber tryNumber1 = (TryNumber) o;
        return tryNumber == tryNumber1.tryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryNumber);
    }
}
