package calculator;

public class PositiveInteger {
    private final int number;

    public PositiveInteger(String input) {
        this.number = Integer.parseInt(input);
    }

    public int getNumber() {
        return number;
    }
}
