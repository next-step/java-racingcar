package step2;

import java.util.Arrays;

public enum Operator implements Operate {
    PLUS("+") {
        @Override
        public CalculatorNumber operate(CalculatorNumber firstOperand, CalculatorNumber secondOperand) {
            return firstOperand.plus(secondOperand);
        }
    },
    MINUS("-") {
        @Override
        public CalculatorNumber operate(CalculatorNumber firstOperand, CalculatorNumber secondOperand) {
            return firstOperand.minus(secondOperand);
        }
    },
    TIMES("*") {
        @Override
        public CalculatorNumber operate(CalculatorNumber firstOperand, CalculatorNumber secondOperand) {
            return firstOperand.times(secondOperand);
        }
    },
    DIVIDE_BY("/") {
        @Override
        public CalculatorNumber operate(CalculatorNumber firstOperand, CalculatorNumber secondOperand) {
            return firstOperand.divideBy(secondOperand);
        }
    };

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public static Operator findByValue(String value) {
        return Arrays.stream(Operator.values())
                .filter(e -> e.value.equals(value))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("사칙연산 기호가 아닙니다.")
                );
    }
}

interface Operate {
    CalculatorNumber operate(CalculatorNumber firstOperand, CalculatorNumber secondOperand);
}
