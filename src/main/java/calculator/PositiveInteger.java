package calculator;

public class PositiveInteger {
    private final int positiveInteger;

    public PositiveInteger(String input) {
        this.positiveInteger = Integer.parseInt(input);
    }

    public int getPositiveInteger() {
        return positiveInteger;
    }
}
