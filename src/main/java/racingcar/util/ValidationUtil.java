package racingcar.util;

import racingcar.Constant;


public class ValidationUtil {

    public static void isNameLength(String name) {
        if (name.length() > Constant.INPUT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(Constant.ERROR_INPUT_NAME_LENGTH);
        }
    }


    private static void isNegativeNum(int cntInput) {
        if (cntInput < 1) {
            throw new IllegalArgumentException(Constant.ERROR_NEGATIVE_NUMBER);
        }
    }

    public static boolean isNumber(String cntInput) {

        try {
            int num = Integer.getInteger(cntInput);
            isNegativeNum(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constant.ERROR_COUNT_NUMBER);
        }
        return true;
    }

}
