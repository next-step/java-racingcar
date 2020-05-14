package step2;

public enum Operator {
    ADD("+") {
        @Override
        public double calculate(double num1, double num2) {
            return num1 + num2;
        }
    },
    MINUS("-") {
        @Override
        public double calculate(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY("*") {
        @Override
        public double calculate(double num1, double num2) {
            return num1 * num2;
        }
    },
    DEVIDE("/") {
        @Override
        public double calculate(double num1, double num2) {
            if(num2 == 0) throw new IllegalArgumentException("It cannot be divided by zero.");
            return num1 / num2;
        }
    };
    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator matchOperator(String str) {
        Operator op;
        switch (str) {
            case "+":
                op = Operator.ADD;
                break;
            case "-":
                op = Operator.MINUS;
                break;
            case "*":
                op = Operator.MULTIPLY;
                break;
            case "/":
                op = Operator.DEVIDE;
                break;
            default:
                throw new IllegalArgumentException("This is Disabled character.");
        }
        return op;
    }

    public abstract double calculate(double num1, double num2);
}
