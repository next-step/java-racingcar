package study.step2;

public class Operator {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private Operator() {}

    public static int execute(Integer num1, String operator, Integer num2) {
        switch (operator) {
            case PLUS:
                return num1 + num2;
            case MINUS:
                return num1 - num2;
            case MULTIPLY:
                return num1 * num2;
            case DIVIDE:
                if (num1 % num2 != 0) {
                    throw new IllegalArgumentException(CalculatorError.DIVIDE_RESULT_MUST_INTEGER);
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException(CalculatorError.UNSUPPORTED_OPERATOR);
        }
    }
}
