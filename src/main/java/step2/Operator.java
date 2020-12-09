package step2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

public enum Operator {

    PLUS("+") {
        @Override
        public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
            return number1.add(number2);
        }
    },
    MINUS("-") {
        @Override
        public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
            return number1.subtract(number2);
        }
    },
    DIVIDE("/") {
        @Override
        public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
            return number1.divide(number2, 0, BigDecimal.ROUND_DOWN);
        }
    },
    MULTIPLY("*") {
        @Override
        public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
            return number1.multiply(number2);
        }
    };

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator getOperatorFor(String text) {
        Optional<Operator> optionalOperator = Arrays.stream(values())
                .filter(e -> e.symbol.equals(text))
                .findFirst();
        if (optionalOperator.isPresent()) {
            return optionalOperator.get();
        }
        throw new IllegalArgumentException();
    }


    public abstract BigDecimal calculate(BigDecimal number1, BigDecimal number2);
}
