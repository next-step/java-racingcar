package calculator;

public enum Operator {
    ADD("+") {
        long calculate(long x, long y) {
            return x + y;
        }
    },
    MINUS("-") {
        long calculate(long x, long y) {
            return x - y;
        }
    },
    MULTIPLE("*") {
        long calculate(long x, long y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        long calculate(long x, long y) {
            return x / y;
        }
    };

    String value;

    Operator(String value) {
        this.value = value;
    }

    static Operator findOperatorByValue(String operatorValue) {
        for (Operator operator : values()) {
            if (operator.value.equals(operatorValue)) {
                return operator;
            }
        }
        throw new IllegalArgumentException();
    }

    abstract long calculate(long x, long y);
}
