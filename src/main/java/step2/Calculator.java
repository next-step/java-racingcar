package step2;

import step2.util.StringUtils;

import static step2.common.ExceptionMessage.*;

public class Calculator {

    private final int FIRST_VALUE_IN_INPUT_VAL = 0;

    private final int ONE = 1;
    private final int TWO = 2;

    public int process(String inputVal){

        String[] splitInputValBySpace = StringUtils.splitInputValBySpace(inputVal);
        validationInputValue(splitInputValBySpace);

        int resultValue = Integer.parseInt(splitInputValBySpace[FIRST_VALUE_IN_INPUT_VAL]);

        int arithmethicCount = getArithmethicCount(splitInputValBySpace.length);

        for(int i = 0; i < arithmethicCount; i++){
            String operation = splitInputValBySpace[getOperationIndex(i)];
            String operationValue = splitInputValBySpace[getOperationValueIndex(i)];

            resultValue = OperatorType.calculate(operation,resultValue,Integer.parseInt(operationValue));

        }

        return resultValue;
    }

    private int getOperationIndex(int i){
        return TWO * i + ONE;
    }

    private int getOperationValueIndex(int i){
        return TWO * (i + ONE);
    }

    private int getArithmethicCount(int totalLength){
        return  totalLength / TWO;
    }

    private void validationInputValue(String[] inputVal){
        if (inputVal.length % TWO != ONE) throw new IllegalArgumentException(ILLEGAL_ARGS_COUNT);

    }
}
