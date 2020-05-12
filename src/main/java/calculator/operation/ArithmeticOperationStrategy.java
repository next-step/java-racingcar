package calculator.operation;

import calculator.exception.ErrorMessage;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum ArithmeticOperationStrategy {

    PLUS("+", Math::addExact),
    MINUS("-", Math::subtractExact),
    TIMES("*", Math::multiplyExact),
    DIVIDE("/", Math::floorDiv);

    private final String expression;
    private final BiFunction<Integer, Integer, Integer> function;

    ArithmeticOperationStrategy(final String expression, final BiFunction<Integer, Integer, Integer> function) {
        this.expression = expression;
        this.function = function;
    }

    public static ArithmeticOperationStrategy of(final String expression) {
        return Arrays.stream(ArithmeticOperationStrategy.values())
                .filter(operator -> expression.equals(operator.expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ErrorMessage.NOT_SUPPORTED_ARITHMETIC, expression)));
    }

    public Integer operate(final Integer operandX, final Integer operandY) {
        return function.apply(operandX, operandY);
    }
}
