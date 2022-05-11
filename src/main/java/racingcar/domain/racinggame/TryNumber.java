package racingcar.domain.racinggame;

public class TryNumber {

    private static final int MIN_VALUE = 0;
    private static final String DECREASE_ERROR_MESSAGE = "최소값(0) 이하로 감소 시킬수 없습니다.";
    private static final String TRYNUMBER_ERROR_MESSAGE = "최소값(0) 이하를 가질수 없습니다.";

    private int value;

    public TryNumber(int tryNumber) {
        if (tryNumber <= MIN_VALUE) {
            throw new IllegalArgumentException(TRYNUMBER_ERROR_MESSAGE);
        }

        this.value = tryNumber;
    }

    public void decrease() {
        if (value <= MIN_VALUE) {
            throw new IllegalArgumentException(DECREASE_ERROR_MESSAGE);
        }

        value--;
    }

    public int getValue() {
        return value;
    }

    public boolean isNotZero() {
        return value > MIN_VALUE;
    }

    @Override
    public String toString() {
        return "TryNumber{" +
                "value=" + value +
                '}';
    }
}
