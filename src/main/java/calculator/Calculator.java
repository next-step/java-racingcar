package calculator;

import calculator.enums.OperatorEnum;
import calculator.utils.StringUtil;
import calculator.utils.ValidationUtil;

public class Calculator {

    public int calculate(String input) {
        String[] values = StringUtil.splitString(input);

        int leftNum = Integer.parseInt(values[0]);
        String strOperator;

        for (int i = 1; i < values.length; i = i + 2) {
            strOperator = values[i];

            ValidationUtil.checkInvalidValue(values[i+1]);
            int intValue = Integer.parseInt(values[i+1]);

            leftNum = OperatorEnum.getOperator(strOperator)
                            .operate(leftNum, intValue);
        }

        return leftNum;
    }
}




