package calculator;

enum Operator {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVISION("/");

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

public class Calculator {
    int add(int operandA, int operandB) {
        return operandA + operandB;
    }

    int subtract(int operandA, int operandB) {
        return operandA - operandB;
    }

    int multiply(int operandA, int operandB) {
        return operandA * operandB;
    }

    int divide(int operandA, int operandB) {
        return operandA / operandB;
    }

    void nullCheck(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
    }

    void operCheck(String input) throws IllegalArgumentException {
        if (!input.contains(Operator.PLUS.getSymbol()) &&
        !input.contains(Operator.MINUS.getSymbol()) &&
        !input.contains(Operator.TIMES.getSymbol()) &&
        !input.contains(Operator.DIVISION.getSymbol())) {
            throw new IllegalArgumentException("입력값에 사칙연산이 없습니다.");
        }
    }
}
