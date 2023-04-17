package StringAdder;

public class PositiveNumber {
    private int number;

    public PositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("input must be a non-negative integer");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
