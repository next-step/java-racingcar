package model;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(int number) {
        int ZERO_NUMBER = 0;

        if (number <= ZERO_NUMBER) {
            throw new RuntimeException();
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
