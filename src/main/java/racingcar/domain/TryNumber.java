package racingcar.domain;

public class TryNumber {

    private int tryNumber;

    private TryNumber() {
    }

    public TryNumber(final int tryNumber) {
        validateTryNumber(tryNumber);
        this.tryNumber = tryNumber;
    }

    private void validateTryNumber(final int input) {
        if (input < 0) {
            throw new RuntimeException("올바르지 않은 값입니다.");
        }
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
