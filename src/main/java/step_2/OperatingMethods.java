package step_2;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum OperatingMethods {
    ADDITION("+", (primary, secondary) -> Long.sum(primary, secondary.longValue())),
    SUBTRACTION("-", (primary, secondary) -> Long.sum(primary, -secondary.longValue())),
    MULTIPLY("*", (primary, secondary) -> {
        primary *= secondary;
        return primary;
    }),
    DIVISION("/", (primary, secondary) -> {
        if (secondary == 0) MessageConstants.DIVIDE_BY_ZERO.sendViolation();
        return primary / secondary;
    });

    private final String operatorString;
    private final BiFunction<Long, Integer, Long> expression;

    OperatingMethods(String operatorString, BiFunction<Long, Integer, Long> expression) {
        this.operatorString = operatorString;
        this.expression = expression;
    }


    public static Optional<OperatingMethods> valueOfString(String symbolText) {
        return Arrays.stream(OperatingMethods.values())
                .filter(method -> method.operatorString.equalsIgnoreCase(symbolText))
                .distinct()
                .findFirst();
    }

    public Long calculate(Long currentValue, Integer nextValue) {
        return expression.apply(currentValue, nextValue);
    }
}
