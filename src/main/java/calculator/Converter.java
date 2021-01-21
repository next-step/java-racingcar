package calculator;

public class Converter {
    public static double toDouble(String numericString) {
        try {
            return Double.parseDouble(numericString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형태의 문자가 아닙니다.");
        }
    }
}
