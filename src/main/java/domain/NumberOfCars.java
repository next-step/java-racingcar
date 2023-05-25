package domain;

import java.util.List;

public class NumberOfCars {
    public static final int MIN_VALUE = 0;

    private final int value;

    public NumberOfCars(int value) {
        if (value < MIN_VALUE) {
            throw new RuntimeException("NumberOfCars can not be negative");
        }
        this.value = value;
    }

    public static NumberOfCars toNumberOfCars(List<CarName> receive) {
        return new NumberOfCars(receive.size());
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NumberOfCars)) {
            return false;
        }
        NumberOfCars numberOfCars = (NumberOfCars) obj;
        return this.value == numberOfCars.value;
    }
}
