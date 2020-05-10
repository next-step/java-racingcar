package calculator;

import java.util.Arrays;
import java.util.Objects;

public enum Operator {
    PLUS("+") {
        @Override
        public double calculate(double beforeResult, double afterResult) {
            return beforeResult + afterResult;
        }
    },
    MINIS("-") {
        @Override
        public double calculate(double beforeResult, double afterResult) {
            return beforeResult - afterResult;
        }
    },
    MULTIPLY("*") {
        @Override
        public double calculate(double beforeResult, double afterResult) {
            return beforeResult * afterResult;
        }
    },
    DIVISION("/") {
        @Override
        public double calculate(double beforeResult, double afterResult) {
            if (afterResult == 0) {
                throw new IllegalArgumentException();
            }
            return beforeResult / afterResult;
        }
    };

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public abstract double calculate(double beforeResult, double afterResult);

    public static Operator findOperator(String operator) {
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(values())
                .filter(v -> v.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
