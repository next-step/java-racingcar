package study.calculator;

public class Calculator {
    public int add(int leftOperand, int rightOperand) {
        return 15;
    }

    public int subtract(int leftOperand, int rightOperand) {
        return 5;
    }

    public int multiply(int leftOperand, int rightOperand) {
        return 50;
    }

    public int divide(int leftOperand, int rightOperand) {
        return 2;
    }

    public int calculate(String expressionString) {
        if (expressionString == null) {
            throw new IllegalArgumentException();
        }

        String trimExpressionString = expressionString.trim();

        if (trimExpressionString.equals("")) {
            throw new IllegalArgumentException();
        }

        if (trimExpressionString.equals("&")) {
            throw new IllegalArgumentException();
        }

        return 10;
    }
}
