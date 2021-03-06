package study.step2.validation;

import java.util.Arrays;

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

    public static String validateOperator(String value) {
        if(!Arrays.asList(CalculatorConst.OPERATOR).contains(value)) {
            throw new IllegalArgumentException(CalculatorConst.MESSAGE_NOT_OPERATOR);
        }
        return value;
    }
}
