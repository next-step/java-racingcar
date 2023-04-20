package domain;

public class NumberOfCars {
    public final static int MIN_VALUE = 0;

    private final int value;

    public NumberOfCars(int value) {
        if (value < MIN_VALUE) {
            throw new RuntimeException("NumberOfCars can not be negative");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
