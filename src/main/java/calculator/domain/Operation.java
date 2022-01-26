package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.DoubleBinaryOperator;

public enum Operation {

    PLUS("+", (leftNumber, rightNumber) -> leftNumber + rightNumber),
    MINUS("-", (leftNumber, rightNumber) -> leftNumber - rightNumber),
    MULTIPLY("*", (leftNumber, rightNumber) -> leftNumber * rightNumber),
    DIVIDE("/", (leftNumber, rightNumber) -> {
        if(rightNumber.equals(0)) {
            throw new ArithmeticException("[ERROR] 0으로 나눌 수 없습니다.");
        }
        return leftNumber / rightNumber;
    }),
    UNKNOWN(null, null);

    private final String operator;
    private final BiFunction<Double, Double, Double> operate;

    Operation(String operator, BiFunction<Double, Double, Double> operate) {
        this.operator = operator;
        this.operate = operate;
    }

    public static double calculate(String operator, double leftNumber, double rightNumber) {
        return Arrays.stream(values())
            .filter(operation -> operation.operator.equals(operator))
            .findAny()
            .get().operate.apply(leftNumber, rightNumber);
    }
}
