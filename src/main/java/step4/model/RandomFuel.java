package step4.model;

import java.util.Objects;
import java.util.Random;

public class RandomFuel implements Fuel {

    private static final int MAXIMUM_NUMBER = 9;
    private static final int VALID_NUMBER = 4;
    private Random fuel;

    public RandomFuel() {
        this.fuel = getRandom();
    }

    protected Random getRandom() {
        return new Random();
    }

    @Override
    public boolean isValid() {
        return this.fuel.nextInt(MAXIMUM_NUMBER) >= VALID_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomFuel that = (RandomFuel) o;
        return Objects.equals(fuel, that.fuel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuel);
    }
}
