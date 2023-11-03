package calculator;

public class StringCalculator {
    public static int cal(String text) {
        int result = 0;
        if (isBlank(text)) {
            result = 0;
        }

        return result;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
