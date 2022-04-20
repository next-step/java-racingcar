package racingCar;

public class PositiveNumber {
    private int value;

    public PositiveNumber(String value) {
        this.value = toInt(value);
        validate(this.value);
    }

    private int toInt(String value) {
        int number = Integer.parseInt(value);

        return number;
    }

    private void validate(int number) {
        if (number < 0) {
            throw new RuntimeException("Negative number is not allowed");
        }
    }

    public int getValue() {
        return this.value;
    }
}
