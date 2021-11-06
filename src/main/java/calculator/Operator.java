package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (firstOperand, secondOperand) -> (firstOperand + secondOperand)),
    MINUS("-", (firstOperand, secondOperand) -> (firstOperand - secondOperand)),
    MULTIPLY("*", (firstOperand, secondOperand) -> (firstOperand * secondOperand)),
    DIVIDE("/", (firstOperand, secondOperand) -> {
        if (secondOperand == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        return firstOperand / secondOperand;
    });

    private String operator;
    private BiFunction<Integer, Integer, Integer> operation;

    Operator(String operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public Integer operate(Integer firstOperand, Integer secondOperand) {
        return operation.apply(firstOperand, secondOperand);
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 연산자 입니다."));
    }
}
