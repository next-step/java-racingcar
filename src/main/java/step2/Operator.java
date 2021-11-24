package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (result, value) -> result + value),
    SUB("-", (result, value) -> result - value),
    MUL("*", (result, value) -> result * value),
    DIV("/", (result, value) -> result / value);

    private static final String IAE_MESSAGE = "사칙연산 기호를 확인해주세요 :(";

    private String operation;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operation, BiFunction<Integer, Integer, Integer> expression) {
        this.operation = operation;
        this.expression = expression;
    }

    public static Operator getOperatorByCode(String operation) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.operation.equals(operation))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(IAE_MESSAGE));
    }

    public int calculate(Integer result, Integer value) {
        return expression.apply(result, value);
    }

}
