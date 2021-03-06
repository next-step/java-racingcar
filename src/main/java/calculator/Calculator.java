package calculator;

import operator.Operation;
import utils.StringUtils;

public class Calculator {

    public Calculator() {
    }

    public int calculate(String expression) {
        if (StringUtils.isNullAndBlank(expression)) {
            throw new IllegalArgumentException();
        }
        return getResult(splitBlank(expression));
    }

    private String[] splitBlank(String expression) {
        return expression.split(" ");
    }

    private int getResult(String[] data) {
        int sum = stringToInt(data[0]);
        for (int i = 0; i < data.length - 2; i += 2) {
            Operation operator = Operation.getOperation(data[i + 1]);
            sum = operator.apply(sum, stringToInt(data[i + 2]));
        }
        return sum;
    }

    private int stringToInt(String digitValue) {
        return Integer.parseInt(digitValue);
    }


}
