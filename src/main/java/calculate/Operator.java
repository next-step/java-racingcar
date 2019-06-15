package calculate;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public enum Operator {
    ADDITION("+", (number1, number2) -> number1 + number2),
    SUBTRACTION("-", (number1, number2) -> number1 - number2),
    DIVISION("/", (number1, number2) -> number1 / number2),
    MULTIPLICATION("*", (number1, number2) -> number1 * number2);
    
    private BinaryOperator<Integer> calculator;
    private String mathSign;
    
    Operator(String mathSign, BinaryOperator<Integer> calculator) {
        this.calculator = calculator;
        this.mathSign = mathSign;
    }
    
    public int calculate(int number1, int number2) {
        return calculator.apply(number1, number2);
    }
    
    public static Operator getMathSign(String sign) {
        Operator[] operators = Operator.values();
        return Arrays.stream(operators)
                .filter(operator -> sign.equals(operator.mathSign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INCORRECT_MATH_SIGN.getMessage()));
    }
    
    public static boolean hasMathSign(String sign) {
        Operator[] operators = Operator.values();
        return Arrays.stream(operators)
            .anyMatch(operator -> sign.equals(operator.mathSign));
    }
}
