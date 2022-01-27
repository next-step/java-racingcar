package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Operation {

    private static final List<String> operations = Arrays.asList("+", "-", "*", "/");

    private String operation;

    public Operation(String operation) {
        validateOperation(operation);
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public int operate(Operand left, Operand right) {
        switch (operation) {
            case "+":
                return left.getNumber() + right.getNumber();
            case "-":
                return left.getNumber() - right.getNumber();
            case "*":
                return left.getNumber() * right.getNumber();
            case "/":
                if (right.getNumber() == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다");
                }
                return left.getNumber() / right.getNumber();
        }
        return 0;
    }

    private void validateOperation(String operation) {
        if (!operations.contains(operation)) {
            throw new IllegalArgumentException("[ERROR] " + operation + "은 사칙연산 기호가 아닙니다.");
        }
    }
}
