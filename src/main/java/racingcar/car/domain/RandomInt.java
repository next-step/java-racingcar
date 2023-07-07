package racingcar.car.domain;

import java.util.Objects;
import java.util.Random;

public class RandomInt {

    private static final Random random = new Random();

    private final int number;

    public RandomInt() {
        this(10, random);
    }

    public RandomInt(int bound) {
        this(bound, random);
    }

    public RandomInt(int bound, Random random) {
        this.number = random.nextInt(bound);
    }

    public boolean isGreaterOrEqualThan(int other) {
        return this.number >= other;
    }

    public boolean isGreaterOrEqualThan(RandomInt other) {
        return this.number >= other.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RandomInt randomInt = (RandomInt) o;
        return number == randomInt.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
