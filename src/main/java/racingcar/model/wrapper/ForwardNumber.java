package racingcar.model.wrapper;

import racingcar.exception.ForwardNumberException;

import java.util.Objects;

public class ForwardNumber {
    private final int number;

    public ForwardNumber(int number) {
        if (isInvalidNumber(number)) {
            throw new ForwardNumberException("0~9 사이의 숫자 외에는 전진숫자로 허용되지 않습니다.");
        }
        this.number = number;
    }

    private boolean isInvalidNumber(int number) {
        return number < 0 ||
                number > 9;
    }

    public boolean isForwardNumber() {
        return this.number >= 4 &&
                this.number <= 9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForwardNumber that = (ForwardNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
