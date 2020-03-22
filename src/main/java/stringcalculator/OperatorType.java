package stringcalculator;

public enum OperatorType {
    PLUS_OPERATOR("+") {
        @Override
        public double calculate(double sum, double nextNumber) {
            return sum + nextNumber;
        }
    },
    MINUS_OPERATOR("-") {
        @Override
        public double calculate(double sum, double nextNumber) {
            return sum - nextNumber;
        }
    },
    MULTIPLY_OPERATOR("*") {
        @Override
        public double calculate(double sum, double nextNumber) {
            return sum * nextNumber;
        }
    },
    DIVIDE_OPERATOR("/") {
        @Override
        public double calculate(double sum, double nextNumber) {
            if (nextNumber == 0) {
                throw new IllegalArgumentException("0 으로 나눌수 없습니다.");
            }
            return sum / nextNumber;
        }
    };

    private String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public static OperatorType createOperator(String operator) {
        if(operator.equals(PLUS_OPERATOR.operator)) {
            return PLUS_OPERATOR;
        }

        if(operator.equals(MINUS_OPERATOR.operator)) {
            return MINUS_OPERATOR;
        }

        if(operator.equals(MULTIPLY_OPERATOR.operator)) {
            return MULTIPLY_OPERATOR;
        }

        if(operator.equals(DIVIDE_OPERATOR.operator)) {
            return DIVIDE_OPERATOR;
        }

        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    public abstract double calculate(double sum, double nextNumber);
}
