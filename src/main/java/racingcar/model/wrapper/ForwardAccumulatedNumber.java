package racingcar.model.wrapper;

import racingcar.exception.ForwardAccumulatedNumberException;

import java.util.Objects;

public class ForwardAccumulatedNumber {
    private final int accumulatedNumber;

    public ForwardAccumulatedNumber(int accumulatedNumber) {
        if (accumulatedNumber < 0) {
            throw new ForwardAccumulatedNumberException("음수는 올 수 없습니다.");
        }
        this.accumulatedNumber = accumulatedNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForwardAccumulatedNumber that = (ForwardAccumulatedNumber) o;
        return accumulatedNumber == that.accumulatedNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accumulatedNumber);
    }
}
