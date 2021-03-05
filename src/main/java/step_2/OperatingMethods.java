package step_2;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BiFunction;

public enum OperatingMethods {
    ADD("+", (primary, secondary) -> Long.sum(primary, secondary.longValue())),
    SUB("-", (primary, secondary) -> Long.sum(primary, -secondary.longValue())),
    MUL("*", (primary, secondary) -> {
        primary *= secondary;
        return primary;
    }),
    DIV("/", (primary, secondary) -> {
        if (secondary == 0) MessageConstants.DIVIDE_BY_ZERO.sendViolation();
        return primary / secondary;
    });

    private final String operatorString;
    private final BiFunction<Long, Integer, Long> expression;

    OperatingMethods(String operatorString, BiFunction<Long, Integer, Long> expression) {
        this.operatorString = operatorString;
        this.expression = expression;
    }


    private static Optional<OperatingMethods> valueOfString(String symbolText) {
        return Arrays.stream(OperatingMethods.values())
                .filter(method -> method.operatorString.equalsIgnoreCase(symbolText))
                .distinct()
                .findFirst();
    }

    public static Long valueOfCalculate(String symbolText, Long currentValue, Integer nextValue) {
        return valueOfString(symbolText).orElseThrow(NoSuchElementException::new).expression.apply(currentValue, nextValue);
    }
}
