package racingcar.util;

import racingcar.Constant;

public class ValidationUtil {

    public boolean isNmaeCheck(String name) {
        return isNull(name) && isNameLength(name);
    }

    private boolean isNull(String name) {
        try {
            if (name == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println(Constant.ERROR_INPUT_NAME);
            return false;
        }
        return true;
    }

    private boolean isNameLength(String name) {
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

    public boolean isNumber(String cntInput) {
        try {

        } catch (NumberFormatException e) {
            System.out.println(Constant.ERROR_COUNT_NUMBER);
            return false;
        }
        return true;
    }

}
