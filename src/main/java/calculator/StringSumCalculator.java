package calculator;

public class StringSumCalculator {

    public static final String DELIMITER = "[,:]";

    public static int sum(final String text) {
        int result = 0;
        if (text == null || text.isEmpty()) {
            return result;
        }

        return sumResult(text);
    }

    private static int sumResult(String text) {
        int result = 0;
        String[] split = text.split(DELIMITER);
        for (String s : split) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}
