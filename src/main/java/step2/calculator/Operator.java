package step2.calculator;

public enum Operator implements OperatorService {
    PlUS("+") {
        @Override
        public int calculate(int num1, int num2) {
            return num1 + num2;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLE("*") {
        @Override
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int num1, int num2) {
            if (num2 == 0)
                throw new ArithmeticException();
            return num1 / num2;
        }
    };

    private final String value;

    private Operator(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }

    static Operator getOperator(String inputOperator) {
        OperatorValidator.checkValidOperator(inputOperator);
        if (inputOperator.equals("+"))
            return Operator.PlUS;
        if (inputOperator.equals("-"))
            return Operator.MINUS;
        if (inputOperator.equals("*"))
            return Operator.MULTIPLE;
        return Operator.DIVIDE;
    }
}
