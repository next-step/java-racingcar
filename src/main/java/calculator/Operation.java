package calculator;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {

    PULS("+") {
        @Override
        public Integer apply(Integer number1, Integer number2) {
            return number1 + number2;
        }
    },
    MINUS("-") {
        @Override
        public Integer apply(Integer number1, Integer number2) {
            return number1 - number2;
        }
    },
    MULTIPLY("*") {
        @Override
        public Integer apply(Integer number1, Integer number2) {
            return number1 * number2;
        }
    },
    DIVIDE("/") {
        @Override
        public Integer apply(Integer number1, Integer number2) {
            return number1 / number2;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    private static final Map<String, Operation> stringToOperationEnum =
            Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));

    public static Operation findOperation (String symbol) {
        return stringToOperationEnum.get(symbol);
    }

    public abstract Integer apply(Integer number1, Integer number2);

    @Override
    public String toString() {
        return symbol;
    }
}

