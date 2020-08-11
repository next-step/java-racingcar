package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS("+", (value1, value2) ->  value1 + value2),
    MINUS("-", (value1, value2) -> value1 - value2),
    MULTIPLY("*", (value1, value2) -> value1 * value2),
    DIVIDE("/", (value1, value2) -> value1 / value2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> operation;

    OperatorType (String operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static OperatorType searchOperation(String operator) {
        return Arrays.stream(OperatorType.values())
                .filter((opType) -> operator.equals(opType.getOperator()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public Integer calculate(Integer firstOperand, Integer secondOperand) {
        return operation.apply(firstOperand, secondOperand);
    }

    private String getOperator() {
        return operator;
    }

}
