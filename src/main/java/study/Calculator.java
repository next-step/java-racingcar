package study;

class Calculator {
    private int result = 0;

    int calculate(String equation) {
        checkValidEquation(equation);

        String[] operList = split(equation);
        result = add(toInt(operList[0]));

        for (int i = 1; i < operList.length - 1; i = i + 2 ) {
            result = operate(operList[i], operList[i+1]);
        }

        return result;
    }

    private int operate(String operator, String operand) {
        if (isNotValidOperator(operator)) {
            throw new IllegalArgumentException();
        }

        if (isAddOperator(operator)) {
            return add(toInt(operand));
        } else if (isSubtractOperator(operator)) {
            return subtract(toInt(operand));
        } else if (isMultiplyOperator(operator)) {
            return multiply(toInt(operand));
        } else if (isDivideOperator(operator)) {
            return divide(toInt(operand));
        }

        return result;
    }

    private String[] split(String equation) {
        return equation.split(" ");
    }

    private void checkValidEquation(String equation) {
        if (equation == null || equation.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotValidOperator(String word) {
        return !isValidOperator(word);
    }

    private boolean isValidOperator(String word) {
        return isAddOperator(word)
                || isSubtractOperator(word)
                || isMultiplyOperator(word)
                || isDivideOperator(word);
    }

    private boolean isAddOperator(String word) {
        return word.equals("+");
    }

    private boolean isSubtractOperator(String word) {
        return word.equals("-");
    }

    private boolean isMultiplyOperator(String word) {
        return word.equals("*");
    }

    private boolean isDivideOperator(String word) {
        return word.equals("/");
    }

    private int toInt(String word) {
        return Integer.parseInt(word);
    }

    private int add(int oper) {
        return result + oper;
    }

    private int subtract(int oper) {
        return result - oper;
    }

    private int multiply(int oper) {
        return result * oper;
    }

    private int divide(int oper) {
        return result / oper;
    }
}

