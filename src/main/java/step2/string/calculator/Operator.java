package step2.string.calculator;


import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operator implements Operation {
    PLUS("+") {
        public int operate(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        public int operate(int x, int y) {
            return x - y;
        }
    },
    TIMES("*") {
        public int operate(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public int operate(int x, int y) {
            return x / y;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator fromString(String symbol) {
        final Map<String, Operator> stringToEnum = Stream.of(values()).collect(toMap(Object::toString, e-> e));
        Optional<Operator> currentOperator = Optional.ofNullable(stringToEnum.get(symbol));
        return currentOperator.orElseThrow(() -> new IllegalArgumentException(Constants.IS_NOT_VALID_OPERATOR));
    }

    @Override
    public String toString() {
        return symbol;
    }

}
