package calculator.util;

import java.util.Arrays;

public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    public abstract double apply(double x, double y);

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }


    /**
     * from은 toString이 반환하는 문자열을 해당 열거 타입 상수로 변환해주는 기능
     */
    public static Operation from(String symbol) {
        return Arrays.stream(values())
            .filter(operation -> symbol.equals(operation.symbol))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 사칙 연산자가 아닙니다!"));
    }
}
