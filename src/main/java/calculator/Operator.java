package calculator;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {
    PLUS("+") {
        OperandNumber operate(OperandNumber operand1, OperandNumber operand2) {
            return new OperandNumber(operand1.doubleValue() + operand2.doubleValue());
        }
    },
    MINUS("-") {
        OperandNumber operate(OperandNumber operand1, OperandNumber operand2) {
            return new OperandNumber(operand1.doubleValue() - operand2.doubleValue());
        }
    },
    MULTIPLY("*") {
        OperandNumber operate(OperandNumber operand1, OperandNumber operand2) {
            return new OperandNumber(operand1.doubleValue() * operand2.doubleValue());
        }
    },
    DIVIDE("/") {
        OperandNumber operate(OperandNumber operand1, OperandNumber operand2) {
            return new OperandNumber(operand1.doubleValue() / operand2.doubleValue());
        }
    },
    ;

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    abstract OperandNumber operate(OperandNumber operand1, OperandNumber operand2);

    public static Optional<Operator> find(String operator) {
        return Arrays.asList(Operator.values()).stream().filter(o -> o.operator.equals(operator))
            .findFirst();
    }
}
