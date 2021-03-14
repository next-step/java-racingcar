package racing.models;

import java.util.function.Supplier;

public class Car implements Cloneable {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String DEFAULT_NAME = "empty";

    public static final int MIN_BOUNDARY_VALUE = 0;
    public static final int MAX_BOUNDARY_VALUE = 9;
    public static final int MIN_MOVABLE_VALUE = 4;

    private final String name;

    private int distance;

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.distance = 0;
    }

    public Car() {
        this(DEFAULT_NAME);
    }

    public String getName() {
        return name;
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
