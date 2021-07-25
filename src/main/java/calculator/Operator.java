package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    ADD("+") {
        @Override
        public IntBinaryOperator execute() {
            return Integer::sum;
        }
    },
    SUB("-") {
        @Override
        public IntBinaryOperator execute() {
            return (a, b) -> a - b;
        }
    },
    MUL("*") {
        @Override
        public IntBinaryOperator execute() {
            return (a, b) -> a * b;
        }
    },
    DIV("/") {
        @Override
        public IntBinaryOperator execute() {
            return (a, b) -> a / b;
        }
    };

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static Operator valueOfString(String str) {
        return Arrays.stream(Operator.values())
                .filter(i -> str.equals(i.getOperator()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public abstract IntBinaryOperator execute();
}
