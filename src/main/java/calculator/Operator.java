package calculator;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {
    PLUS("+") {
        Number operate(Number operand1, Number operand2) {
            return operand1.plus(operand2);
        }
    },
    MINUS("-") {
        Number operate(Number operand1, Number operand2) {
            return operand1.minus(operand2);
        }
    },
    MULTIPLY("*") {
        Number operate(Number operand1, Number operand2) {
            return operand1.multiple(operand2);
        }
    },
    DIVIDE("/") {
        Number operate(Number operand1, Number operand2) {
            return operand1.divide(operand2);
        }
    },
    ;

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    abstract Number operate(Number operand1, Number operand2);

    public static Optional<Operator> find(String operator) {
        return Arrays.asList(Operator.values()).stream().filter(o -> o.operator.equals(operator))
            .findFirst();
    }
}
