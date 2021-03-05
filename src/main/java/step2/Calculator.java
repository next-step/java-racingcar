package step2;

import step2.FourOperation.*;

public class Calculator {

    private OperationFactory factory = new FourOperationFactory();

    public int fourRuleCalculations(String input) {

        String[] inputArg = input.split(" ");

        isEmptyInput(input);

        int leftNum = Integer.valueOf(inputArg[0]);
        for (int i = 1; i < inputArg.length - 1; i=i+2) {
            Operation fourRuleOperation = operand(inputArg[i]);
            leftNum = fourRuleOperation.operation(leftNum, Integer.valueOf(inputArg[i+1]));
        }
        return leftNum;
    }

    private Operation operand(String operand){
        return factory.getOperation(operand);
    }

    private void isEmptyInput(String input) {
        if(input == null || input.length() == 0){
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 공백 문자일 경우 에러발생");
        }
    }
}


