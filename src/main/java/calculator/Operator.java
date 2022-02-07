package calculator;

import java.util.Arrays;

enum Operator {
    PLUS("+") {
        @Override
        public double operate(double number1, double number2) {
            return number1 + number2;
        }
    }, MINUS("-") {
        @Override
        public double operate(double number1, double number2) {
            return number1 - number2;
        }
    }, MULTI("*") {
        @Override
        public double operate(double number1, double number2) {
            return number1 * number2;
        }
    }, DIVIDE("/") {
        @Override
        public double operate(double number1, double number2) {
            if (number2 == 0) {
                throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다.");
            }
            return Math.round((number1 / number2) * Math.pow(10, DIGIT_RANGE)) / Math.pow(10,
                DIGIT_RANGE);
        }
    };

    private final static int DIGIT_RANGE = 2;
    private final String identifier;

    Operator(String identifier) {
        this.identifier = identifier;
    }

    public static double calculate(String identifier, double number1, double number2) {
        return Arrays.stream(values()).filter(operator -> operator.identifier.equals(identifier))
            .findAny().map(operator -> operator.operate(number1, number2))
            .orElseThrow(IllegalArgumentException::new);
    }

    public abstract double operate(final double number1, final double number2);
}
