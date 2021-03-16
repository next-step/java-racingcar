package step2;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public Integer calculate(String strInput) {
        validBlankOrNull(strInput);
        String[] arrInput = splitStr(strInput);
        Integer[] arrNumbers = getNumbers(arrInput);
        String[] arrOperations = getOperations(arrInput);

        return loopAllOperator(arrNumbers, arrOperations);
    }

    public Integer loopAllOperator(Integer[] arrNumbers, String[] arrOperation) {
        Integer result = arrNumbers[0];
        for (Integer i = 0; i < arrOperation.length; i++) {
            result = Operation.operator(result, arrNumbers[i + 1], arrOperation[i]);
        }
        return result;
    }


    public String[] splitStr(String strInput) {
        return strInput.split(" ");
    }


    public void validBlankOrNull(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }

    public void validAllOperation(String[] arrInput) {
        for (String strOperation : arrInput) {
            Operation.validate(strOperation);
        }
    }


    public Integer[] getNumbers(String[] arrInput) {
        List<Integer> arrNumbers = new ArrayList<>();
        for (int i = 0; i < arrInput.length; i += 2) {
            arrNumbers.add(Integer.parseInt(arrInput[i]));
        }

        return arrNumbers.toArray(new Integer[0]);
    }

    public String[] getOperations(String[] arrInput) {
        List<String> arrOperations = new ArrayList<>();
        for (int i = 1; i < arrInput.length; i += 2) {
            arrOperations.add(arrInput[i]);
        }
        validAllOperation(arrOperations.toArray(new String[0]));
        return arrOperations.toArray(new String[0]);
    }


}
