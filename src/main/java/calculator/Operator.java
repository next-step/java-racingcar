package calculator;

import java.util.Arrays;

public enum Operator implements Operable {
    ADD("+") {
        @Override
        public int operate(int number1, int number2) {
            return number1 + number2;
        }
    },
    SUBTRACT("-") {
        @Override
        public int operate(int number1, int number2) {
            return number1 - number2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int operate(int number1, int number2) {
            return number1 * number2;
        }
    },
    DIVIDE("/") {
        @Override
        public int operate(int number1, int number2) {
            if (number2 == 0) {
                throw new ArithmeticException("`number1` cannot be divided by zero(`number2`)");
            }
            return number1 / number2;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator generateOperatorBySymbol(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Parameter `symbol(%s)` must be valid", symbol)));
    }
}
