package carRace.step5.domain.util;

import carRace.step5.domain.util.ErrorMessage;

/**
 * 데이터 입력받기
 */
public class CarDataCheck {

    /**
     * 시도횟수값 체크
     *
     * @param paramValue
     * @return 시도할 횟수
     */
    public static int checkTryCount(String paramValue) {
        checkNumberValue(paramValue);
        return Integer.valueOf(paramValue);
    }

    /**
     * string형을 받아 ',' 기준으로 배열만들기
     *
     * @param paramValue
     * @return
     */
    public static String[] checkName(String paramValue) {
        checkNamesValue(paramValue);

        for(String carName : paramValue.split(",")){
            checkNameLength(carName);
        }

        return paramValue.split(",");
    }

    /**
     * 숫자 체크
     *
     * @param paramValue
     */
    public static void checkNumberValue(String paramValue) {
        isNullCheck(paramValue);
        isEmptyCheck(paramValue);
        isNumberCheck(paramValue);
        isZeroCheck(paramValue);
    }

    /**
     * 이름 체크
     *
     * @param paramValue
     */
    private static void checkNamesValue(String paramValue) {
        isNullCheck(paramValue);
        isEmptyCheck(paramValue);
    }

    private static void checkNameLength(String paramValue) {
        if (paramValue.length() > 5) {
            throw new IndexOutOfBoundsException(ErrorMessage.getINDEXOUTOFBOUNDSEXCEPTION());
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
