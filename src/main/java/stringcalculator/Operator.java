package stringcalculator;

public enum Operator {

    PLUS(CommonConstant.PLUS_SIGN) {
        @Override
        public int getSolve(int firstNumber, int secondNumber) {
            return firstNumber + secondNumber;
        }
    },
    MINUS(CommonConstant.MINUS_SIGN) {
        @Override
        public int getSolve(int firstNumber, int secondNumber) {
            return firstNumber - secondNumber;
        }
    },
    MULTIPLY_BY(CommonConstant.MINUS_SIGN) {
        @Override
        public int getSolve(int firstNumber, int secondNumber) {
            return firstNumber * secondNumber;
        }
    },
    DIVIDED_BY(CommonConstant.DIVISION_SIGN) {
        @Override
        public int getSolve(int firstNumber, int secondNumber) {
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

    public abstract int getSolve(int firstNumber, int secondNumber);
}
