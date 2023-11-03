package calculator;

public class StringCalculator {
    public static int cal(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return Integer.parseInt(text);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
