package calculator;

import java.util.Arrays;

import static calculator.NumberParser.checkMathOperator;

public enum Operator {

    ADDITION("+") {
        long calculate(long x, long y) {
            return x + y;
        }
    },
    SUBTRACTION("-") {
        long calculate(long x, long y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        long calculate(long x, long y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        long calculate(long x, long y) {
            divideByZero(y);
            return x / y;
        }
    };

    private String value;

    Operator(String value) {
        this.value = value;
    }

    protected void divideByZero(long inputNumber) {
        if (inputNumber == 0) {
            throw new IllegalArgumentException();
        }
    }

    static Operator findOperator(String input) {
        checkMathOperator(input);

        return Arrays.stream(Operator.values())
                .filter(operator -> operator.value.equals(input))
                .findAny().orElseThrow(IllegalArgumentException::new);
    }

    abstract long calculate(long x, long y);
}
