package util;

public class InputParser {

    private InputParser() {
        throw new IllegalStateException("Utility class");
    }

    public static int stringToInteger(String str) {
        if (StringUtil.isBlank(str)) {
            return 0;
        }

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("숫자가 아닙니다. 입력 문자 : " + str);
        }
    }

    public static void isPositive(int num) {
        if (num < 0) {
            throw new RuntimeException("입력한 숫자가 양수가 아닙니다. 입력 숫자 : " + num);
        }
    }

}
