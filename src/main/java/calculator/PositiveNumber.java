package calculator;

public class PositiveNumber {

    private int number;

    public PositiveNumber(String value) {
        this(Integer.parseInt(value));
    }

    private PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
