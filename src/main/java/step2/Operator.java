package step2;

import java.util.function.BinaryOperator;

public enum Operator {
    PLUS(Operand::plus),
    MINUS(Operand::minus),
    MULTIPLY(Operand::multiply),
    DIVIDE(Operand::divide);

    private final BinaryOperator<Operand> operation;

    Operator(BinaryOperator<Operand> operation) {
        this.operation = operation;
    }

    public Operand operate(Operand first, Operand second) {
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
