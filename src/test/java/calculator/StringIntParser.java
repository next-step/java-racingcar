package calculator;

public class StringIntParser {

    public static Integer mapToInt(String input) throws IllegalArgumentException{
        try {
            int num = Integer.parseInt(input);
            validatePositiveNum(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("input must be number", e);
        }
    }

    private static void validatePositiveNum(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("input number must be positive");
        }
    }
}
