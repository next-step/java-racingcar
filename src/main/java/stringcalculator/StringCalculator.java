package stringcalculator;

public class StringCalculator {
    public Integer calculate(String input) {
        validateInput(input);
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(input);
        return arithmeticExpression.evaluate();
    }

    private void validateInput(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("Input can not be null or empty.");
        }
    }
}
