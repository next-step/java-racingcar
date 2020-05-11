package step2.calculator;

import java.util.Arrays;

public enum Operator implements OperatorService {
    PlUS("+") {
        @Override
        public int operate(int firstNumber, int nextNumber) { return firstNumber + nextNumber; }
    },
    MINUS("-") {
        @Override
        public int operate(int firstNumber, int nextNumber) {
            return firstNumber - nextNumber;
        }
    },
    MULTIPLE("*") {
        @Override
        public int operate(int firstNumber, int nextNumber) { return firstNumber * nextNumber; }
    },
    DIVIDE("/") {
        @Override
        public int operate(int firstNumber, int nextNumber) {
            if (nextNumber == 0)
                throw new ArithmeticException();
            return firstNumber / nextNumber;
        }
    };

    private final String value;

    private Operator(String value) {
        this.value = value;
    }

    String getValue() { return this.value; }

    static Operator getOperator(String inputOperator) {
        return (Operator)Arrays.stream(Operator.values())
                .filter(target -> target.getValue().equals(inputOperator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
