package step2.domain;

import org.apache.commons.lang3.StringUtils;
import step2.exception.BlankException;

import static java.lang.Integer.parseInt;

public class Calculator {

    public int calculate(String input) {
        validNull(input);
        String[] splits = splitBlank(input);
        int loopSize = splits.length;
        int operateResult = parseInt(splits[0]);
        for (int i = 1; i < loopSize; i+=2) {
            String operator = splits[i];
            int nextNumber = parseInt(splits[i+1]);
            operateResult = Operator.operate(getOperatedNumber(operateResult,nextNumber), operator);
        }
        return operateResult;
    }
    private OperatedNumber getOperatedNumber(int operateResult , int nextNumber){
        return new OperatedNumber(operateResult, nextNumber);
    }

    private String[] splitBlank(String input) {
        return input.split(" ");
    }

    private static void validNull(String input) {
        if (StringUtils.isBlank(input)) {
            throw new BlankException();
        }
    }

}
