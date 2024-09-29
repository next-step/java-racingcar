package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        return Integer.parseInt(text);
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }
}
