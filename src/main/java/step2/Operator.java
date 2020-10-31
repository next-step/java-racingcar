package step2;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {
    ADD("+") {
        @Override
        public int operate(int lhs, int rhs) {
            return lhs + rhs;
        }
    },

    SUBTRACT("-") {
        @Override
        public int operate(int lhs, int rhs) {
            return lhs - rhs;
        }
    },

    MULTIPLY("*") {
        @Override
        public int operate(int lhs, int rhs) {
            return lhs * rhs;
        }
    },

    DIVIDE("/") {
        @Override
        public int operate(int lhs, int rhs) {
            try {
                return lhs / rhs;
            } catch(ArithmeticException ex) {
                throw new IllegalArgumentException(ex);
            }
        }
    };

    final static Map<String, Operator> symbolMapping =
            Arrays.stream(values()).collect(
                    Collectors.toUnmodifiableMap(op -> op.symbol, Function.identity())
            );
    final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator parseOperator(String symbol) {
        Operator res = symbolMapping.get(symbol);
        if(res == null) throw new IllegalArgumentException();
        return res;
    }

    public abstract int operate(int lhs, int rhs);
}
