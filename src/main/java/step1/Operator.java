package step1;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public enum Operator {
    ADD((num1, num2) -> num1 + num2),
    SUBTRACT((num1, num2) -> num1 - num2),
    MULTIPLY((num1, num2) -> num1 * num2),
    DIVIDE((num1, num2) -> num1 / num2);

    private BinaryOperator<Integer> expression;
    static Map<String, Operator> operator;
    Operator(BinaryOperator<Integer> expression) {
        this.expression = expression;
    }

    static {
        operator = new HashMap<>();
        operator.put("+", Operator.ADD);
        operator.put("-", Operator.SUBTRACT);
        operator.put("*", Operator.MULTIPLY);
        operator.put("/", Operator.DIVIDE);
    }

    public int calculate(int result, int value) {
        return expression.apply(result, value);
    }
}
