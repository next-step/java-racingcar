package step2;

import java.util.function.BinaryOperator;

public enum Operator {
    PLUS((n1, n2) -> n1 + n2),
    MINUS((n1, n2) -> n1 - n2),
    MULTIPLY((n1, n2) -> n1 * n2),
    DIVIDE((n1, n2) -> n1 / n2);

    private final BinaryOperator<Integer> operation;

    Operator(BinaryOperator<Integer> operation) {
        this.operation = operation;
    }

    public int calculate(int first, int second) {
        return operation.apply(first, second);
    }

    static Operator getOperator(String operator) {
        if (operator.equals("+")) {
            return PLUS;
        }
        if (operator.equals("-")) {
            return MINUS;
        }
        if (operator.equals("*")) {
            return MULTIPLY;
        }
        if (operator.equals("/")) {
            return DIVIDE;
        }
        throw new IllegalArgumentException();
    }
}
