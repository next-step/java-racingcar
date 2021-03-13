package racing;

import java.util.function.Supplier;

public class Car implements Cloneable {
    public static int MIN_BOUNDARY_VALUE = 0;
    public static int MAX_BOUNDARY_VALUE = 9;
    public static int MIN_MOVABLE_VALUE = 4;

    private int distance;

    public Car() {
        distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void tryMove(Supplier<Integer> randomSupplier) {
        final int value = randomSupplier.get();

        if (value < MIN_BOUNDARY_VALUE || value > MAX_BOUNDARY_VALUE) {
            throw new IllegalArgumentException();
        }

        if (value >= MIN_MOVABLE_VALUE) {
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
