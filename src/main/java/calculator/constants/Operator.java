package calculator.constants;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Operator {
    MULTIPLY("*"),
    DIVIDE("/"),
    PLUS("+"),
    MINUS("-");

    private String symbol;

    Operator(String code) {
        this.symbol = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator getOperator(String symbol) {
        switch (symbol) {
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            case "+":
                return PLUS;
            case "-":
                return MINUS;
        }
        return null;
    }

    public static boolean isContains(String symbol) {
        return Arrays.stream(Operator.values())
                .map(Operator::getSymbol)
                .collect(Collectors.toList())
                .contains(symbol);
    }
}
