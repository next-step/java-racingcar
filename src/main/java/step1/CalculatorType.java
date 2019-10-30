package step1;
import java.util.function.BinaryOperator;

public enum CalculatorType {
    ADD((num1, num2) -> num1 + num2),
    SUBTRACT((num1, num2) -> num1 - num2),
    MULTIPLY((num1, num2) -> num1 * num2),
    DIVIDE((num1, num2) -> num1 / num2);

    private BinaryOperator<Integer> expression;

    CalculatorType(BinaryOperator<Integer> expression) {
        this.expression = expression;
    }

    public int calculate(int result, int value) {
        return expression.apply(result, value);
    }
}
