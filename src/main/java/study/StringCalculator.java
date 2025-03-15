package study;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        // default value
        return 0;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
