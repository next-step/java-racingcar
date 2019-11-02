package stringcalculator.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
    DIVIDE("/", (operand1, operand2) -> operand1 / operand2);

    private final String indicator;
    private BiFunction<Integer, Integer, Integer> function;

    Operation(final String indicator, final BiFunction<Integer, Integer, Integer> function) {
        this.indicator = indicator;
        this.function = function;
    }

    public static Integer operate(int operand1, int operand2, String operator) {
        Optional<Operation> actualOperation = Arrays.stream(values())
                .filter(enableOperation -> enableOperation.indicator.equals(operator))
                .findFirst();

        Operation operation = actualOperation.orElseThrow(IllegalArgumentException::new);
        return operation.function.apply(operand1, operand2);
    }
}
