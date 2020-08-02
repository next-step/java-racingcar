package step2;

public enum Operator {

    PLUS("+") {
        @Override
        public int apply(int firstNumber, int secondNumber) {
            return firstNumber + secondNumber;
        }
    },
    MINUS("-") {
        @Override
        public int apply(int firstNumber, int secondNumber) {
            return firstNumber - secondNumber;
        }
    },
    MULTIPLY_BY("*") {
        @Override
        public int apply(int firstNumber, int secondNumber) {
            return firstNumber * secondNumber;
        }
    },
    DIVIDED_BY("/") {
        @Override
        public int apply(int firstNumber, int secondNumber) {
            if (secondNumber == 0) {
                throw new IllegalArgumentException(CommonConstant.INVALID_DIVIDED_BY_ZERO);
            }
            return firstNumber / secondNumber;
        }
    };

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public abstract int apply(int firstNumber, int secondNumber);

    public static int operate(String operator, int firstNumber, int secondNumber) {
        if (operator.equals(PLUS.operator)) {
            return Operator.PLUS.apply(firstNumber, secondNumber);
        }
        if (operator.equals(MINUS.operator)) {
            return Operator.MINUS.apply(firstNumber, secondNumber);
        }
        if (operator.equals(MULTIPLY_BY.operator)) {
            return Operator.MULTIPLY_BY.apply(firstNumber, secondNumber);
        }
        if (operator.equals(DIVIDED_BY.operator)) {
            return Operator.DIVIDED_BY.apply(firstNumber, secondNumber);
        }
        throw new IllegalArgumentException(operator + CommonConstant.INVALID_OPERATOR);
    }

}
