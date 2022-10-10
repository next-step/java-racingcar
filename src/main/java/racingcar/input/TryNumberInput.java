package racingcar.input;

public class TryNumberInput {

    private int tryNumber;

    private TryNumberInput() {
    }

    public TryNumberInput(final int tryNumber) {
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
