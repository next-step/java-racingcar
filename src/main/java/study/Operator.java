package study;

import java.util.Arrays;

public enum Operator {

    PLUS("+") {
        @Override
        Operand calculate(Operand operand1, Operand operand2) {
            return new Operand(operand1.getValue() + operand2.getValue());
        }
    },
    MINUS("-") {
        @Override
        Operand calculate(Operand operand1, Operand operand2) {
            return new Operand(operand1.getValue() - operand2.getValue());
        }
    },
    MULTIPLY("*") {
        @Override
        Operand calculate(Operand operand1, Operand operand2) {
            return new Operand(operand1.getValue() * operand2.getValue());
        }
    },
    DIVIDE("/") {
        @Override
        Operand calculate(Operand operand1, Operand operand2) {
            return new Operand(operand1.getValue() / operand2.getValue());
        }
    };

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator findBySymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다 : " + symbol));
    }

    abstract Operand calculate(Operand operand1, Operand operand2);
}
