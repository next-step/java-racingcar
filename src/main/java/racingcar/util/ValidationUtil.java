package racingcar.util;

import racingcar.Constant;

import java.util.Arrays;

public class ValidationUtil {

    public static boolean isNmaeCheck(String[] names) {
        if(!Arrays.stream(names).allMatch(s -> isNameLength(s))){
            return false;
        }

        return true;
    }

    public static boolean isNameLength(String name) {
        try {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Constant.ERROR_INPUT_NAME_LENGTH);
            return false;
        }
        return true;
    }

    public static boolean isNumber(String cntInput) {
        try {

        } catch (NumberFormatException e) {
            System.out.println(Constant.ERROR_COUNT_NUMBER);
            return false;
        }
        return true;
    }

}
