import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum Operator {
    ADD("+", Integer::sum),
    SUBTRACT("-", (a, b) -> a - b),
    DIVIDE("/", (a, b) -> a / b),
    MULTIPLY("*", (a, b) -> a * b);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> action;
    private static final Map<String, Operator> operators;

    static {
        operators = Arrays.stream(values()).collect(Collectors.toMap(element -> element.operator, element -> element));
    }

    Operator(String operator, BiFunction<Integer, Integer, Integer> action) {
        this.operator = operator;
        this.action = action;
    }

    public static Operator getOperator(String operator) {
        return operators.get(operator);
    }

    public int operate(int a, int b) {
        return action.apply(a, b);
    }
}
