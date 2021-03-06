package calculator;

import operator.Operation;
import utils.StringUtils;

import java.util.StringTokenizer;

public class Calculator {
    private final String DELIMITER = " ";

    public Calculator() {
    }

    public Integer calculate(String expression) {
        if (StringUtils.isNullAndBlank(expression)) {
            throw new IllegalArgumentException();
        }
        return getResult(splitBlank(expression));
    }

    private StringTokenizer splitBlank(String expression) {
        return new StringTokenizer(expression, DELIMITER);
    }

    private Integer getResult(StringTokenizer token) {
        Integer sum = stringToInteger(token.nextToken());
        while (token.hasMoreTokens()) {
            Operation operator = getOperationByToken(token.nextToken());
            sum = operator.apply(sum, stringToInteger(token.nextToken()));
        }
        return sum;
    }

    private int stringToInteger(String digitValue) {
        return Integer.parseInt(digitValue);
    }

    private Operation getOperationByToken(String symbol) {
        return Operation.getOperation(symbol);
    }

}
