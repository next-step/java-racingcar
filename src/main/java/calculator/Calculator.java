package calculator;

public class Calculator {
    public int calculate(String input) {
        String[] expression = input.split(" ");

        checkInputValidation(input);
        checkExpressionValidation(expression);

        int ret = Integer.parseInt(expression[0]);

        for (int i = 1; i < expression.length; i += 2) {
            checkSign(expression[i]);
            checkIntValue(expression[i + 1]);

            String sign = expression[i];
            int num = Integer.parseInt(expression[i + 1]);

            ret = calculateOneStep(sign, ret, num);
        }
        return ret;
    }

    private void checkInputValidation(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkExpressionValidation(String[] expression) {
        int MIN_LENGTH = 3;

        if (expression.length < MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSign(String sign) {
        if (!isSign(sign)) {
            throw new IllegalStateException();
        }
    }

    private void checkIntValue(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private int calculateOneStep(String sign, int num1, int num2) {
        switch (sign) {
            case "+":
                return num1 + num2;

            case "-":
                return num1 - num2;

            case "*":
                return num1 * num2;

            case "/":
            default:
                return num1 / num2;
        }
    }

    private boolean isSign(String str) {
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }
}
