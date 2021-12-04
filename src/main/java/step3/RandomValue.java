package step3;

public class RandomValue {
    private int value;

    public RandomValue(int value) {
        if(value < 0 || value > 9) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof RandomValue)) {
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
