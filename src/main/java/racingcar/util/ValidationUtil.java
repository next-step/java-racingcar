package racingcar.util;

import racingcar.Constant;

import java.util.Arrays;

public class ValidationUtil {

    public static boolean isNmaeCheck(String[] names) {
        if (!Arrays.stream(names).allMatch(s -> isNameLength(s))) {
            return false;
        }
        return true;
    }

    public static boolean isNumCheck(String num) {
        if (isNegativeNumber(num) && isNumber(num)) {
            return false;
        }
        return true;
    }

    public static boolean isNameLength(String name) {
        try {
            if (name.length() > Constant.INPUT_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Constant.ERROR_INPUT_NAME_LENGTH);
            return false;
        }
        return true;
    }

    private static boolean isNegativeNumber(String cntInput) {
        double num = Double.parseDouble(cntInput);

        if (num < Constant.INPUT_ZERO_NUM) {
            throw new IllegalArgumentException(Constant.ERROR_NEGATIVE_NUMBER);
        }
        return true;
    }

    private static boolean isNumber(String cntInput) {
        try {
            Integer.getInteger(cntInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constant.ERROR_COUNT_NUMBER);
        }
        return true;
    }

}
