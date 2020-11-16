package carRace.step5.domain.util;

import org.junit.platform.commons.function.Try;

public class TryCountCheck {

    /**
     * 숫자 체크
     *
     * @param paramValue
     */
    public static int checkNumberValue(String paramValue) {
        isEmptyAndNullCheck(paramValue);
        isNumberCheck(paramValue);

        return Integer.valueOf(paramValue);
    }

    /**
     * 문자열 입력 체크
     *
     * @param paramValue
     */
    private static void isNumberCheck(String paramValue) {
        for (int i = 0; i < paramValue.length(); i++) {
            isDetailNumberCheck(paramValue.charAt(i));
        }
    }

    private static void isDetailNumberCheck(char inputValue) {
        if (!('0' <= inputValue && inputValue <= '9')) {
            throw new NumberFormatException(ErrorMessage.getNUMBERFORMATEXCEPTION());
        }
    }

    /**
     * empty 체크
     *
     * @param paramValue
     */
    private static void isEmptyAndNullCheck(String paramValue) {
        if ("".equals(paramValue) || paramValue == null) {
            throw new NullPointerException(ErrorMessage.getEmptyException());
        }
    }
}
