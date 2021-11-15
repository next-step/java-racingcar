package Racing.type;

import java.util.Objects;
import java.util.Random;

public class RacingNumber {
    private final static double RANDOM_BOUND = 10.0;
    private final double value;

    public RacingNumber(int number) {
        value = number;
    }

    public RacingNumber(double number) {
        value = number;
    }

    public static RacingNumber getRandomNumber() {
        int number = new Random().nextInt((int) RacingNumber.RANDOM_BOUND);
        return new RacingNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingNumber that = (RacingNumber) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int parseInt() {
        return (int) value;
    }
}
