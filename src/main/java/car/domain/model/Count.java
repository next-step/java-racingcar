package car.domain.model;

import car.exceptions.NumberNegativeException;
import java.util.Objects;

public final class Count {

    private int tryCount;

    public Count(final int userInputCount) {
        this.tryCount = validatePositive(userInputCount);
    }

    /**
     * @param userInputCount
     * @return int
     * @exception NumberNegativeException 음수인 경우
     */
    private int validatePositive(final int userInputCount) {
        if (userInputCount < 0) {
            throw new NumberNegativeException("양수로 입력해 주세요");
        }
        return userInputCount;
    }

    public void decreaseTryCount() {
        tryCount--;
    }

    public int getTryCount() {
        return tryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Count count = (Count) o;
        return tryCount == count.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }
}
