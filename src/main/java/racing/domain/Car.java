package racing.domain;

import java.util.function.Supplier;

public class Car implements Cloneable {
    public static final int MAX_NAME_LENGTH = 5;
    private static final String DEFAULT_NAME = "empty";

    public static final int MIN_BOUNDARY_VALUE = 0;
    public static final int MAX_BOUNDARY_VALUE = 9;
    public static final int MIN_MOVABLE_VALUE = 4;
    public static final int INIT_DISTANCE = 0;

    private final String name;
    private int distance;

    public Car() {
        this(DEFAULT_NAME, INIT_DISTANCE);
    }

    public Car(String name) {
        this(name, INIT_DISTANCE);
    }

    public Car(String name, int distance) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.distance = distance;
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
