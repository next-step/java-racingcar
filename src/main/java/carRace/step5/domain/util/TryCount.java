package carRace.step5.domain.util;

import org.junit.platform.commons.function.Try;

public class TryCount{

    /**
     * 숫자 체크
     *
     * @param paramValue
     */
    public static int checkNumberValue(String paramValue) {
        isNullCheck(paramValue);
        isEmptyCheck(paramValue);
        isNumberCheck(paramValue);
        isZeroCheck(paramValue);

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
     * 0 체크
     *
     * @param paramValue
     */
    private static void isZeroCheck(String paramValue) {
        if ("0".equals(paramValue)) {
            throw new ArrayIndexOutOfBoundsException(ErrorMessage.getARRAYINDEXOUTOFBOUNDSEXCEPTION());
        }
    }


    /**
     * empty 체크
     *
     * @param paramValue
     */
    private static void isEmptyCheck(String paramValue) {
        if ("".equals(paramValue)) {
            throw new NumberFormatException(ErrorMessage.getEmptyException());
        }
    }

    /**
     * null 체크
     *
     * @param paramValue
     */
    private static void isNullCheck(String paramValue) {
        if (paramValue == null) {
            throw new NullPointerException(ErrorMessage.getNullException());
        }
    }
}
