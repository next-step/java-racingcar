package domain;

public class NumberOfCars {
    private final int number;
    public NumberOfCars(int number) {
        if (number < 0)
            throw new RuntimeException("NumberOfCars can not be negative");
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
