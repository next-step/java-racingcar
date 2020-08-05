import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    ADD("+", (x, y) -> x + y),
    SUB("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> {
        if (y == 0) {
            throw new IllegalArgumentException();
        }
        return x / y;
    });
    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operation(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operation findOperator(String inputOoperator) {
        return Arrays.stream(values())
                .filter(it -> it.operator.equals(inputOoperator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                ;
    }

    public int calculate(String leftValue, String rightValue) {
        return expression.apply(Integer.parseInt(leftValue), Integer.parseInt(rightValue));
    }
}
