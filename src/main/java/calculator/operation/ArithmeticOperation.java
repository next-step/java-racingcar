package calculator.operation;

import calculator.exception.ErrorMessage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum ArithmeticOperation {

    PLUS("+", Math::addExact),
    MINUS("-", Math::subtractExact),
    TIMES("*", Math::multiplyExact),
    DIVIDE("/", Math::floorDiv);

    private final String expression;
    private final BiFunction<Integer, Integer, Integer> function;

    public static final Map<String, ArithmeticOperation> map = new HashMap<>();
    static {
        Arrays.stream(ArithmeticOperation.values())
                .forEach(value -> map.put(value.expression, value));
    }

    ArithmeticOperation(final String expression, final BiFunction<Integer, Integer, Integer> function) {
        this.expression = expression;
        this.function = function;
    }

    public static ArithmeticOperation fromExpression(final String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        throw new IllegalArgumentException(String.format(ErrorMessage.NOT_SUPPORTED_ARITHMETIC, expression));
    }

    public Integer operate(final Integer operandX, final Integer operandY) {
        return function.apply(operandX, operandY);
    }
}
