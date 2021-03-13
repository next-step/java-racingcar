package racing;

import java.util.function.Supplier;

public class Car implements Cloneable {
    private int distance;

    public Car() {
        distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void tryMove(Supplier<Integer> randomSupplier) {
        final int value = randomSupplier.get();

        if (value < 0 || value > 9) {
            throw new IllegalArgumentException();
        }

        if (value >= 4) {
            distance++;
        }
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
