package step2;


import org.apache.commons.lang3.StringUtils;

public class Calculator {

    public String calculate(String strInput) {
        validBlankOrNull(strInput);
        String[] arrInput = splitStr(strInput);
        validOperation(arrInput);
        return "";
    }


    public String[] splitStr(String strInput) {
        return strInput.split(" ");
    }


    public void validBlankOrNull(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }

    public void validOperation(String[] arrInput) {
        for (int i = 1; i < arrInput.length; i += 2) {
            if (!isOperation(arrInput[i])) {
                throw new IllegalArgumentException();
            }
        }
    }

    public Boolean isOperation(String inputOperation) {
        boolean result = false;
        for (Operation operation : Operation.values()) {
            result = operation.strOperation.equals(inputOperation) || result;
        }
        return result;
    }


    public String operator(String inputNum1, String inputNum2, String inputOperation) {
        return "";
    }

    public Integer minus(Integer input1, Integer input2) {
        return 1;
    }

    public Integer plus(Integer input1, Integer input2) {
        return 1;
    }

    public Integer multiple(Integer input1, Integer input2) {
        return 1;
    }

    public Integer division(Integer input1, Integer input2) {
        return 1;

    }

}
