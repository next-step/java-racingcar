package racingcar.domain;

import java.util.Objects;

public class TryCount {

    private static final int COUNT_ONCE = 1;
    private static final int MIN_COUNT = 0;
    private static final String ERROR_NOT_IN_RANGE_MESSAGE = "은(는) 범위에 포함되지 않는 숫자입니다. 0 이상의 숫자를 입력하세요.";
    private static final String ERROR_NOT_A_NUMBER_MESSAGE = "은(는) 숫자가 아닙니다. 숫자만 입력받을 수 있습니다.";

    private final int number;

    public TryCount(String number) {
        this.number = parseNumberOrThrow(number);
        if (isNotInRage(this.number)) {
            throw new IllegalArgumentException(number + ERROR_NOT_IN_RANGE_MESSAGE);
        }
    }

    public TryCount(int number) {
        this(String.valueOf(number));
    }

    private int parseNumberOrThrow(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(number + ERROR_NOT_A_NUMBER_MESSAGE);
        }
    }

    private boolean isNotInRage(int number) {
        return number < MIN_COUNT;
    }

    public TryCount minus() {
        return new TryCount(this.number - COUNT_ONCE);
    }

    public boolean isNotZero() {
        return number != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryCount tryCount = (TryCount) o;
        return number == tryCount.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "TryCount{" +
                "number=" + number +
                '}';
    }
}
