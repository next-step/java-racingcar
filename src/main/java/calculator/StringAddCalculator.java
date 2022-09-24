package calculator;

public class StringAddCalculator {
    public static final String SEPARATOR = "[,;]";

    private StringAddCalculator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(split(text));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(String[] values) {
        PositiveNumber result = new PositiveNumber(0);
        for (String number : values) {
            result = result.plus(new PositiveNumber(number));
        }
        return result.getNumber();
    }

    private static String[] split(String text) {
        return text.split(SEPARATOR);
    }

}
