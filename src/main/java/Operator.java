import java.util.Arrays;
import java.util.function.BiFunction;

public enum  Operator {
    PULS ("+", (firstValue, secondValue) -> firstValue + secondValue),
    MINUS ("-", (firstValue, secondValue) -> firstValue - secondValue),
    MULTIPLY ("*", (firstValue, secondValue) -> firstValue * secondValue),
    DIVIDED ("/", (firstValue, secondValue) -> {
        if (secondValue == 0) {
            throw new IllegalArgumentException(ExceptionMessage.DIVIDE_BY_ZERO);
        }
        return firstValue / secondValue;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int result(String operator, int firstValue, int secondValue) {
        return findSymbols(operator).expression.apply(firstValue, secondValue);
    }

    public static Operator findSymbols(String operate) {
        return Arrays.stream(values())
                .filter(operator -> operator.operator.equals(operate))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_ARITHMETIC_SIMBOLS));
    }
}