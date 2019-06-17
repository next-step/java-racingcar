package study;

import java.util.regex.Pattern;

public class Calculator {

    public int computation(int num1, int num2, String operator) {

        if (operator.equals("+")) {
            return num1 + num2;
        } else if (operator.equals("-")) {
            return num1 - num2;
        } else if (operator.equals("*")) {
            return num1 * num2;
        } else if (operator.equals("/")) {
            return num1 / num2;
        }

        return 0;
    }

    public String checkPolicyOperator(String operator) {
        boolean isContainsOperator = "+_*/".contains(operator);
        if (isContainsOperator) {
            return operator;
        }

        throw new IllegalArgumentException();
    }

    public String[] getSplitFormula(String formula) {
        return formula.split(" ");
    }

    public boolean isNumber(String value) {
        return Pattern.matches("^[0-9]*$", value);
    }
}
