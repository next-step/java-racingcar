package calculator;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {
    PLUS("+") {
        OperandNumber operate(OperandNumber operand1, OperandNumber operand2) {
            return operand1.plus(operand2);
        }
    },
    MINUS("-") {
        OperandNumber operate(OperandNumber operand1, OperandNumber operand2) {
            return operand1.minus(operand2);
        }
    },
    MULTIPLY("*") {
        OperandNumber operate(OperandNumber operand1, OperandNumber operand2) {
            return operand1.multiple(operand2);
        }
    },
    DIVIDE("/") {
        OperandNumber operate(OperandNumber operand1, OperandNumber operand2) {
            return operand1.divide(operand2);
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
