package stringcalculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class ArithmeticOperator {

    private Map<Type, BinaryOperator<Integer>> operator = new HashMap<>();

    public ArithmeticOperator() {
        operator.put(Type.ADDITION, (num1, num2) -> num1 + num2);
        operator.put(Type.SUBTRACTION, (num1, num2) -> num1 - num2);
        operator.put(Type.MULTIPLICATION, (num1, num2) -> num1 * num2);
        operator.put(Type.DIVISION, (num1, num2) -> {
            if (num1 == 0) {
                throw new IllegalArgumentException("Can not divide by zero");
            }
            return num1 / num2;
        });
    }

    public Integer operate(Type type, Integer num1, Integer num2) {
        return operator.get(type).apply(num1, num2);
    }

    public enum Type {
        ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");

        private String symbol;

        Type(String symbol) {
            this.symbol = symbol;
        }

        public static Type from(String str) {
            return Arrays.stream(Type.values())
                    .filter(symbol -> symbol.getSymbol().equals(str))
                    .findFirst()
                    .orElseGet(() -> {
                        throw new IllegalArgumentException("Unsupported operator");
                    });
        }

        public String getSymbol() {
            return symbol;
        }
    }
}
