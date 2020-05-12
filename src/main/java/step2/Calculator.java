package step2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private static final String DELIMETER = " ";

    public boolean valCheck(String[] input) {

        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("계산식을 입력해주세요.");
        }

        if (input.length % 2 == 0) {
            throw new IllegalArgumentException("계산식이 올바르지 않습니다.");
        }

        return true;
    }

    public static double isNumeric(String s) {
        try {
            return Double.parseDouble(s);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다. " + s);
        }
    }

    public double calculator(String input)
    {

        String[] splitInput = input.split(DELIMETER);
        valCheck(splitInput);

        double result = isNumeric(splitInput[0]);
        for(int i = 1; i < splitInput.length; i += 2) {
            Operator operator = Operator.getOperation(splitInput[i]);
            result = operator.operate(result, isNumeric(splitInput[i+1]));
        }

        return result;
    }
}
