package step2.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PlUS("+", (firstNumber, nextNumber) -> firstNumber + nextNumber),
    MINUS("-", (firstNumber, nextNumber) -> firstNumber - nextNumber),
    MULTIPLE("*", (firstNumber, nextNumber) -> firstNumber * nextNumber),
    DIVIDE("/", (firstNumber, nextNumber) -> firstNumber / nextNumber);

    private final String operatorValue;

    private final BiFunction<Integer, Integer, Integer> expression;

    private Operator(String operatorValue, BiFunction<Integer, Integer, Integer> expression) {
        this.operatorValue = operatorValue;
        this.expression = expression;
    }

    Integer calculate(Integer firstNumber, Integer nextNumber) {
        return this.expression.apply(firstNumber, nextNumber);
    }

    String getOperatorValue() {
        return this.operatorValue;
    }

    static Operator getOperator(String inputOperator) {
        return Arrays.stream(Operator.values())
                .filter(target -> target.getOperatorValue().equals(inputOperator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_OPERATOR));
    }
}
