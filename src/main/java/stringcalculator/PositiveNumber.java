package stringcalculator;

public class PositiveNumber {

    private final int number;

    private PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    static PositiveNumber createPositiveNumber(String input) {
        return new PositiveNumber(Integer.parseInt(input));
    }

    int getNumber() {
        return number;
    }
}
