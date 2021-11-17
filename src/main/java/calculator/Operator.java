package calculator;

import java.util.Arrays;

public enum Operator {
    ADD("+") {
        @Override
        public Number operate(Number left, Number right) {
            return left.add(right);
        }
    },
    SUBTRACT("-") {
        @Override
        public Number operate(Number left, Number right) {
            return left.subtract(right);
        }
    },
    MULTIPLY("*") {
        @Override
        public Number operate(Number left, Number right) {
            return left.multiply(right);
        }
    },
    DIVIDE("/") {
        @Override
        public Number operate(Number left, Number right) {
            return left.divide(right);
        }
    };

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public static Operator of(String value) {
        return Arrays.stream(Operator.values()).filter(op -> op.value.equals(value)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
    }

    public abstract Number operate(Number left, Number right);
}
