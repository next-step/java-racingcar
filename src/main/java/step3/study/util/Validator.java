package step3.study.util;

public class Validator {
    public static int numberCheck(String str) {
        int result;
        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자형식이 아닙니다.");
        }
        return result;
    }
}
