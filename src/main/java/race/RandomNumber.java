package race;

import java.util.Objects;

public class RandomNumber {
    private final int value;

    public RandomNumber(int value) {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public boolean isBigOrEqual(int forwardNumber) {
        return value >= forwardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof RandomNumber))
            return false;
        RandomNumber that = (RandomNumber)o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
