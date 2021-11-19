package study.racingcar.model;

import java.util.Objects;

public class RandomValue {
    private static final int FORWARD_NUMBER = 4;

    private final int randomValue;

    public RandomValue(int randomValue) {
        if (randomValue < 1 || randomValue > 9) {
            throw new IllegalArgumentException("1이상, 9이하의 입력값이여야 합니다.");
        }
        this.randomValue = randomValue;
    }

    public boolean isMovable() {
        return this.randomValue >= FORWARD_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomValue that = (RandomValue) o;
        return randomValue == that.randomValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(randomValue);
    }
}
