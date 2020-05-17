package step2;

import java.util.regex.Pattern;

public class StringValidator {
    private static final Pattern PATTERN_CHECK_NUMBER = Pattern.compile("\\d");

    /**
     * null일경우 IllegalArgumentException throw
     * 
     * @param param : String 판단할 문자열
     */
    public static void checkNull(String param) {
        if (param == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
    }

    /**
     * 빈 문자열이거나 빈 공백 문자열일 경우 IllegalArgumentException throw
     * 
     * @param param : String 판단할 문자열
     * @throws IllegalArgumentException
     */
    public static void checkEmpty(String param) throws IllegalArgumentException {
        String[] splitedStringsBySpace = param.split(" ");

        for (String splitedString : splitedStringsBySpace) {
            if (!splitedString.isEmpty()) {
                return;
            }
        }

        throw new IllegalArgumentException("입력값이 빈 문자열 입니다.");
    }

    /**
     * 입력받은 문자열(param)이 사칙연산 기호가 아니면 IllegalArgumentException
     * 
     * @param param : String, 판단할 문자열
     * @throws IllegalArgumentException
     */
    public static void checkOperator(String param) throws IllegalArgumentException {
        String[] correctOperators = { "+", "-", "*", "/" };

        for (String correctOperator : correctOperators) {
            if (correctOperator.equals(param)) {
                return;
            }
        }

        throw new IllegalArgumentException("올바른 사칙연산 기호가 아닙니다.");
    }

    /**
     * 문자열이 숫자인지 확인한다
     * 
     * @param param : String, 확인할 문자열
     * @return boolean, 숫자일 경우 true, 아닐 경우 false 반환
     */
    public static boolean isNumber(String param) {
        boolean result = false;

        if (param != null) {
            result = PATTERN_CHECK_NUMBER.matcher(param).matches();
        }

        return result;
    }
}
