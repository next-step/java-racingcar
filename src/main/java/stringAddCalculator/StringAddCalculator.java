package stringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        int result = 0;

        if (isNullOrEmpty(text)) {
            return 0;
        }

        return result;
    }

    private static boolean isNullOrEmpty(String text) {
        return (text == null) || (text.isEmpty());
    }


}
