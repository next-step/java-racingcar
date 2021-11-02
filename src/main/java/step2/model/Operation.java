package step2.model;

public enum Operation {
    PLUS("+") {
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
    MULTIPLY("*") {
        @Override
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int num1, int num2) {
            return num1 / num2;
        }
    };

    private String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract int calculate(int num1, int num2);
}