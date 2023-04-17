package domain;

public class NumberOfCars {
    private final int value;
    private final static int MIN_VALUE = 0;
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
