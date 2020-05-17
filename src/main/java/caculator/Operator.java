package caculator;

import java.util.Map;
import java.util.function.BiFunction;

public class Operator {

    private static final Map<String, BiFunction<Double, Double, Double>> OPERATOR_MAP = Map.of(
            "+", (left, right) -> left + right,
            "-", (left, right) -> left - right,
            "/", (left, right) -> left / right,
            "*", (left, right) -> left * right
    );

    public double calculate(final double left, final String operator, final String right) {
        return calculate(left, operator, Double.parseDouble(right));
    }

    public double calculate(final double left, final String operator, final double right) {
        return OPERATOR_MAP.get(operator).apply(left, right);
    }
}
