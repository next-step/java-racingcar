package step2;

import java.util.function.BinaryOperator;

public enum OperatorType {
    PLUS((first, second) -> first + second),
    MINUS((first, second) -> first - second),
    MULTIPLY((first, second) -> first * second),
    DIVIDE((first, second) -> {
        if (second == 0) {
            throw new ArithmeticException("divide by zero");
        }
        return first / second;
    });

    private BinaryOperator<Integer> operator;

    OperatorType(BinaryOperator<Integer> operator) {
        this.operator = operator;
    }

    public int operate(int first, int second) {
        return operator.apply(first, second);
    }
}
