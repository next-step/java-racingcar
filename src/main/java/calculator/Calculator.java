package calculator;

import operator.Operator;
import operator.OperatorFactory;

public class Calculator {

    public Calculator() {
    }

    public int calculate(String expression) {
        if (isBlank(expression)) throw new IllegalArgumentException();
        return getResult(splitBlank(expression));
    }

    private boolean isBlank(String expression) {
        if (expression == null) return true;
        if (expression.equals(" ")) return true;
        if (expression.contains("  ")) return true;
        return false;
    }

    private String[] splitBlank(String expression) {
        return expression.split(" ");
    }

    private int getResult(String[] data) {
        int sum = stringToInt(data[0]);
        for (int i = 0; i < data.length - 2; i += 2) {
            Operator operator = getOperatorByOperatorFactory(data[i + 1]);
            sum = operator.operate(sum, stringToInt(data[i + 2]));
        }
        return sum;
    }

    private Operator getOperatorByOperatorFactory(String operator) {
        return OperatorFactory.getOperator(operator).orElseThrow(
                () -> new IllegalArgumentException());
    }

    private int stringToInt(String digitValue) {
        return Integer.parseInt(digitValue);
    }


}
