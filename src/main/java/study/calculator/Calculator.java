package study.calculator;

public class Calculator {
    public int add(int leftOperand, int rightOperand) {
        return leftOperand + rightOperand;
    }

    public int subtract(int leftOperand, int rightOperand) {
        return leftOperand - rightOperand;
    }

    public int multiply(int leftOperand, int rightOperand) {
        return leftOperand * rightOperand;
    }

    public int divide(int leftOperand, int rightOperand) {
        return leftOperand / rightOperand;
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

        boolean isNextLeftOperand = true;
        boolean isNextOperator = false;
        boolean isNextRightOperand = false;

        int leftOperand = 0;
        int rightOperand = 0;
        String operator = "";

        int result = 0;

        String[] splitExpressions = expressionString.split(" ");

        for (int i = 0; i < splitExpressions.length; ++i) {
            String token = splitExpressions[i];

            if (isNextOperator == false) {
                if (Character.isDigit(token.charAt(0)) == false) {
                    throw new IllegalArgumentException();
                }

            } else {
                if (Character.isDigit(token.charAt(0)) == true) {
                    throw new IllegalArgumentException();
                }

                if (token.equals("+")) {

                }
                else if (token.equals("-")) {

                }
                else if (token.equals("*")) {

                }
                else if (token.equals("/")) {

                } else {
                    throw new IllegalArgumentException();
                }

                operator = token;

                isNextLeftOperand = false;
                isNextOperator = false;
                isNextRightOperand = true;
                continue;
            }

            if (isNextLeftOperand == true) {
                leftOperand = Integer.parseInt(token);

                isNextLeftOperand = false;
                isNextOperator = true;
                isNextRightOperand = false;
                continue;
            }

            if (isNextRightOperand == true) {
                rightOperand = Integer.parseInt(token);

                if (operator.equals("+")) {
                    result = this.add(leftOperand, rightOperand);
                }

                if (operator.equals("-")) {
                    result = this.subtract(leftOperand, rightOperand);
                }

                if (operator.equals("*")) {
                    result = this.multiply(leftOperand, rightOperand);
                }

                if (operator.equals("/")) {
                    result = this.divide(leftOperand, rightOperand);
                }

                isNextLeftOperand = false;
                isNextOperator = true;
                isNextRightOperand = false;

                leftOperand = result;
                operator = "";
                rightOperand = 0;

                continue;
            }

        }

        return result;
    }
}
