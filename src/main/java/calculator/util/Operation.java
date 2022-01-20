package calculator.util;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static final Map<String, Operation> stringToEnum =
        Stream.of(values()).collect(Collectors.
            toMap(Object::toString, e -> e));

    /**
     fromString은 toString이 반환하는 문자열을 해당 열거 타입 상수로 변환해주는 기능
     */
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
}
