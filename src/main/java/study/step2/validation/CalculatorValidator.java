package study.step2.validation;

import study.step2.constant.CalculatorConst;

public class CalculatorValidator {

    public static boolean validateEmpty(String value) {
        if(value == null || value.trim().equals("")) {
            throw new IllegalArgumentException(CalculatorConst.MESSAGE_EMPTY_VALUE);
        }
        return true;
    }

    public static int validateStringToNumber(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CalculatorConst.MESSAGE_NOT_NUMBER);
        }
    }
}
