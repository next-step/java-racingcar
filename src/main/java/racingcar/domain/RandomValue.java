package racingcar.domain;

public class RandomValue {

    private static final int MAX_MOVE_NUM = 4;
    private final int randomValue;

    public RandomValue(int randomValue) {
        this.randomValue = randomValue;
    }

    public int resultValue() {
        if (this.randomValue >= MAX_MOVE_NUM) {
            return 1;
        }

        return 0;
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
        return randomValue;
    }
}
