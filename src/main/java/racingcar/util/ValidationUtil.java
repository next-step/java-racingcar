package racingcar.util;

import racingcar.Constant;

public class ValidationUtil {

    public boolean isNumber(String cntInput) {
        try {
            Integer.parseInt(cntInput);
        } catch (NumberFormatException e) {
            System.out.println(Constant.ERROR_COUNT_NUMBER);
            return false;
        }
        return true;
    }

}
