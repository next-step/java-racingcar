package calculator;

public class CalculatorElement {
    private final int positiveValue;
    public CalculatorElement(String inputString) {
        positiveValue = Integer.parseInt(inputString);
        if (positiveValue < 0) {
            throw new RuntimeException();
        }
    }

    public int toInt() {
        return positiveValue;
    }
}
