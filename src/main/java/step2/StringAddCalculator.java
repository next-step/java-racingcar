package step2;

public class StringAddCalculator {

    private static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }
        return Integer.parseInt(text);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}
