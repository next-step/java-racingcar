package caculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Operator {

    private static final Map<String, BiFunction<Double, Double, Double>> OPERATOR_MAP  = new HashMap<>();
    static {
        OPERATOR_MAP.put("+", (left, right) -> left + right);
        OPERATOR_MAP.put("-", (left, right) -> left - right);
        OPERATOR_MAP.put("/", (left, right) -> left / right);
        OPERATOR_MAP.put("*", (left, right) -> left * right);
    }
    
    public double calculate(final double left, final String operator, final String right) {
        if (!isNumeric(right)) throw new IllegalArgumentException();
        return calculate(left, operator, Double.parseDouble(right));
    }

    public double calculate(final double left, final String operator, final double right) {
        if (!OPERATOR_MAP.containsKey(operator)) throw new IllegalArgumentException();
        return OPERATOR_MAP.get(operator).apply(left, right);
    }

    private boolean isNumeric(final String stringNumber) {
        try {
            Double.parseDouble(stringNumber);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
