package step2;

public class StringValidator {
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
}
