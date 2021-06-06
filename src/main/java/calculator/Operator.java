package calculator;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        int calculate(int firstOperand, int secondOperand) {
            return firstOperand + secondOperand;
        }
    },
    MINUS("-") {
        @Override
        int calculate(int firstOperand, int secondOperand) {
            return firstOperand - secondOperand;
        }
    },
    TIMES("*") {
        @Override
        int calculate(int firstOperand, int secondOperand) {
            return firstOperand * secondOperand;
        }
    },
    DIVISION("/") {
        @Override
        int calculate(int firstOperand, int secondOperand) {
            validateDivideZero(secondOperand);
            return firstOperand / secondOperand;
        }
    };

    private static final String NOT_OPERATOR_EXCEPTION_MESSAGE = "찾아진 입력값이 연산자가 아닙니다.";
    private static final String ZERO_EXCEPTION_MESSAGE = "0으로 나눌 수 없습니다.";
    private String symbol;

    abstract int calculate(int firstOperand, int secondOperand);

    Operator(String symbol) {
        this.symbol = symbol;
    }

    private static void validateDivideZero(int secondOperand) {
        if (secondOperand == 0) {
            throw new IllegalArgumentException(ZERO_EXCEPTION_MESSAGE);
        }
    }

    public static Operator findSymbol(String input) {
        validateNotOperator(input);
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(input))
                .findAny()
                .orElse(null);
    }

    private static void validateNotOperator(String input) {
        if (!input.equals(Operator.PLUS.getSymbol()) &&
                !input.equals(Operator.MINUS.getSymbol()) &&
                !input.equals(Operator.TIMES.getSymbol()) &&
                !input.equals(Operator.DIVISION.getSymbol())) {
            throw new IllegalArgumentException(NOT_OPERATOR_EXCEPTION_MESSAGE);
        }
    }

    public String getSymbol() {
        return symbol;
    }
}
