package step2;

import java.util.Objects;

/**
 * 유효성 검사를 위한 클래스
 */
public final class Validator {

    public static boolean isBlank(String input) {
        return Objects.isNull(input) || input.trim().isEmpty();
    }

    public static boolean isNumeric(String item) {
        try {
            Integer.parseInt(item);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void isDivideByZero(Integer a) {
        if(a == 0) {
            throw new ArithmeticException("divide 연산이 불가합니다.");
        }
    }
}
