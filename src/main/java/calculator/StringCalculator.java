package calculator;

public class StringCalculator {
    private static final String COMMA = ",";
    private static final String DOUBLE_DOT = ":";

    public static int calculateInputText() {
        CalculatorComponent calculatorComponent = StringCalculatorUserInput.getUserInput();
        return calculatorComponent.calculate();
    }
}
