package calculator;

import java.util.function.ToIntBiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0) {
            throw new IllegalArgumentException(CalculConstant.CAN_NOT_DIVIDE_ZERO);
        }
        return num1 / num2;
    });


    private String symbol;
    private ToIntBiFunction<Integer, Integer> operation;

    Operator(String symbol, ToIntBiFunction<Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public int operate(int num1, int num2) {
        return operation.applyAsInt(num1, num2);
    }

    public Operator createOperator(String input){
        for (Operator operator : Operator.values()) {
            if (operator.isSymbol(input)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    private boolean isSymbol(String input) {
        return input.equals(this.symbol);
    }

}
