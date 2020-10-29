package step2.domain;

import step2.exception.EmptyException;
import step2.exception.NullException;

import static java.lang.Integer.parseInt;

public class Calculator {

    public int calculate(String input) {
        validNull(input);
        validEmpty(input);
        return getOperateResult(splitBlank(input));
    }

    private int getOperateResult(String[] splits) {
        int loopSize = getLoopSize(splits);
        int operateResult = getNumber(splits[0]);
        for (int i = 1; i < loopSize; i += 2) {
            int nextNumber = getNumber(splits[i + 1]);
            operateResult = Operator.operate(
                            getOperatedNumber(operateResult, nextNumber),
                            getOperator(splits[i]));
        }
        return operateResult;
    }

    private String getOperator(String operator) {
        return operator;
    }

    private int getNumber(String splitNumber) {
        return parseInt(splitNumber);
    }

    private int getLoopSize(String[] splits) {
        return splits.length;
    }

    private OperatedNumber getOperatedNumber(int operateResult, int nextNumber) {
        return new OperatedNumber(operateResult, nextNumber);
    }

    private String[] splitBlank(String input) {
        return input.split(" ");
    }

    private static void validNull(String input) {
        if (input == null) {
            throw new NullException();
        }
    }

    private static void validEmpty(String input) {
        if (input.isEmpty()) {
            throw new EmptyException();
        }
    }


}
