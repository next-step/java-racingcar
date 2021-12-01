package racinggame.domain;

import java.util.Objects;

public class RandomValue {
    private static final int FORWARD_NUM = 4;

    private final int randomValue;

    public RandomValue(int randomValue) {
        if (randomValue < 0 || randomValue > 9) {
            throw new IllegalArgumentException("1이상의 값이어야 합니다.");
        }

        this.randomValue = randomValue;
    }

    public boolean isMovable() {
        return this.randomValue >= FORWARD_NUM;
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

    @Override
    public String toString() {
        return "RandomValue{" +
                "randomValue=" + randomValue +
                '}';
    }
}
