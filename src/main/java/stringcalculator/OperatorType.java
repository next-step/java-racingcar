package stringcalculator;

import java.util.Arrays;
import java.util.Objects;

public enum OperatorType {
    PLUS_OPERATOR("+", (sum, nextNumber) -> sum + nextNumber),
    MINUS_OPERATOR("-", (sum, nextNumber) -> sum - nextNumber),
    MULTIPLY_OPERATOR("*", (sum, nextNumber) -> sum * nextNumber),
    DIVIDE_OPERATOR("/", (sum, nextNumber) -> {
        if (nextNumber == 0) {
            throw new IllegalArgumentException("0 으로 나눌수 없습니다.");
        }
        return sum / nextNumber;
    });

    private String operator;
    private Calculation calculation;

    OperatorType(String operator, Calculation calculation) {
        this.operator = operator;
        this.calculation = calculation;
    }

    public static OperatorType findOperator(String operator) {
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException("연산자는 null 이 될 수 없습니다.");
        }

        return Arrays.asList(values()).stream()
                .filter(operatorType -> operatorType.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

    public double calculate(double sum, double nextNumber) {
        return calculation.calculate(sum, nextNumber);
    }
}
