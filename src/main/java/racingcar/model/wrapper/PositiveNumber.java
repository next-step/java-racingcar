package racingcar.model.wrapper;

import racingcar.exception.PositiveNumberException;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(int number) {
        if (number < 1) {
            throw new PositiveNumberException("음수는 입력될 수 없습니다.");
        }
        this.number = number;
    }

    public boolean isGreaterThan(int compare) {
        return this.number > compare;
    }

    @Override
    public String toString() {
        return "PositiveNumber{" +
                "number=" + number +
                '}';
    }
}
