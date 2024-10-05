package race;

import java.util.Objects;

public class RandomNumber {
    private final int value;

    public RandomNumber(int value) {
        this.value = value;
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
