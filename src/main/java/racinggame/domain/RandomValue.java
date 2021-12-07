package racinggame.domain;

public class RandomValue {
    private static int MIN = 0;
    private static int MAX = 9;

    private int value;

    public RandomValue(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RandomValue)) {
            return false;
        }

        RandomValue randomValue = (RandomValue) obj;

        return randomValue.value == randomValue.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    public boolean meet(int advanceCondition) {
        return this.value >= advanceCondition;
    }
}
