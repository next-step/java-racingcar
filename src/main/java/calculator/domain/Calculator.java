package calculator.domain;

import calculator.operator.Operation;

import java.util.StringTokenizer;
import static utils.StringUtils.isNullAndBlank;
import static java.lang.Integer.parseInt;
import static calculator.operator.Operation.getOperation;

public class Calculator {
    private final String DELIMITER = " ";

    public Calculator() {
    }

    public Integer calculate(String expression) {
        if (isNullAndBlank(expression)) {
            throw new IllegalArgumentException();
        }
        return getResult(splitBlank(expression));
    }

    private StringTokenizer splitBlank(String expression) {
        return new StringTokenizer(expression, DELIMITER);
    }

    private Integer getResult(StringTokenizer token) {
        Integer sum = parseInt(token.nextToken());
        while (token.hasMoreTokens()) {
            Operation operator = getOperation(token.nextToken());
            sum = operator.apply(sum, parseInt(token.nextToken()));
        }
        return sum;
    }

}
