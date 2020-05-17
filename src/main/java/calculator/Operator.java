package calculator;

public enum Operator implements Operable {
    ADD() {
        @Override
        public int operate(int number1, int number2) {
            return number1 + number2;
        }
    },
    SUBTRACT() {
        @Override
        public int operate(int number1, int number2) {
            return number1 - number2;
        }
    },
    MULTIPLY() {
        @Override
        public int operate(int number1, int number2) {
            return number1 * number2;
        }
    },
    DIVIDE() {
        @Override
        public int operate(int number1, int number2) {
            if (number2 == 0) {
                throw new ArithmeticException("`number1` cannot be divided by zero(`number2`)");
            }
            return number1 / number2;
        }
    };

    Operator() {
    }

    public static Operator OperatorFactory(String operator) {
        if (operator.equals("+")) {
            return ADD;
        }
        if (operator.equals("-")) {
            return SUBTRACT;
        }
        if (operator.equals("*")) {
            return MULTIPLY;
        }
        if (operator.equals("/")) {
            return DIVIDE;
        }
        throw new IllegalArgumentException("Parameter `operator` must be valid");
    }
}
