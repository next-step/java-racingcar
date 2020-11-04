package race.car;

import java.util.Scanner;

/**
 * 데이터 입력받기
 */
public class NumberInput {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputCount() {
        String inputValue = scanner.nextLine();

        valueCheck(inputValue);

        return Integer.valueOf(inputValue);
    }

    /**
     * 저장된 값 확인
     *
     * @param paramValue
     */
    public static void valueCheck(String paramValue) {
        isNullCheck(paramValue);
        isEmptyCheck(paramValue);
        isNumberCheck(paramValue);
        isZeroCheck(paramValue);
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
