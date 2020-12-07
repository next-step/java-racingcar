package calculator;

public class StringCalculator {

    public static int calculate(String strExp) {
        validate(strExp);
        return new Expression(strExp).calculate();
    }

    private static void validate(String strExp) {
        if (strExp == null || strExp.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }
}
