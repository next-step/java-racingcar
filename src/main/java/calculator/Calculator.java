package calculator;

public class Calculator {

    private final String[] input;
    private double result;

    public Calculator(String[] input) {
        this.input = input;
        this.result = Double.parseDouble(input[0]);
    }

    public void execute() {
        for (int i = 1; i < input.length; i += 2) {
            double operand = Double.parseDouble(input[i + 1]);
            this.result = calculate(input[i], result, operand);
        }
    }

    public double getResult() {
        return result;
    }

    private static double calculate(String operator, double result, double operand) {
        switch (operator) {
            case "+":
                return Operator.PLUS.operate(result, operand);
            case "-":
                return Operator.MINUS.operate(result, operand);
            case "*":
                return Operator.MULTI.operate(result, operand);
            default:
                return Operator.DIVIDE.operate(result, operand);
        }
    }
}


enum Operator {
    PLUS() {
        @Override
        public double operate(double number1, double number2) {
            return number1 + number2;
        }
    },
    MINUS() {
        @Override
        public double operate(double number1, double number2) {
            return number1 - number2;
        }
    },
    MULTI() {
        @Override
        public double operate(double number1, double number2) {
            return number1 * number2;
        }
    },
    DIVIDE() {
        @Override
        public double operate(double number1, double number2) {
            if (number2 == 0) {
                throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다.");
            }
            return Math.round((number1 / number2) * Math.pow(10, DIGIT_RANGE)) / Math.pow(10,
                DIGIT_RANGE);
        }
    };

    private static int DIGIT_RANGE = 2;

    public abstract double operate(final double number1, final double number2);
}
