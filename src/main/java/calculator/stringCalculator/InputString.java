package calculator.stringCalculator;


public class InputString {
    public static final int ZERO = 0;

    private String expression;
    private StringCalculator calculator;

    private InputString(String expression, StringCalculator calculator) {
        this.expression = expression;
        this.calculator = calculator;
    }

    public static InputString of(String expression, StringCalculator calculator) {
        return new InputString(expression, calculator);
    }

    public int calculate() {
        if (isEmptyOrNull(expression)) {
            return ZERO;
        }

        return calculator.calculate(expression);
    }

    private boolean isEmptyOrNull(String expression) {
        return isNull(expression) || isEmpty(expression);
    }

    private boolean isNull(String expression) {
        return expression == null;
    }

    private boolean isEmpty(String expression) {
        return expression.isEmpty();
    }
}
