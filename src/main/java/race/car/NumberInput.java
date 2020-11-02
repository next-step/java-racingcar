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
    public static boolean valueCheck(String paramValue) {
        isNullCheck(paramValue);
        isEmptyCheck(paramValue);
        isNumberCheck(paramValue);
        //isZeroCheck(paramValue);

        return true;
    }

    /**
     * 0 체크
     *
     * @param paramValue
     */
    private static void isZeroCheck(String paramValue) {
        if ("0".equals(paramValue)) {
            throw new ArrayIndexOutOfBoundsException("자동차의 갯수를 1개이상으로 입력해주세요");
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
            throw new NumberFormatException("문자를 입력하였습니다. 숫자를 입력해주세요");
        }
    }

    /**
     * empty 체크
     *
     * @param paramValue
     */
    private static void isEmptyCheck(String paramValue) {
        if ("".equals(paramValue)) {
            throw new NumberFormatException("입력하지 않으셨습니다. 숫자를 입력해주세요");
        }
    }

    /**
     * null 체크
     *
     * @param paramValue
     */
    private static void isNullCheck(String paramValue) {
        if (paramValue == null) {
            throw new NullPointerException("Null을 입력하였습니다. 숫자를 입력해주세요");
        }
    }
}
