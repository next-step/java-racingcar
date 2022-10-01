package calculator;

public class StringNumberCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return sum(toPositiveIntegers(split(input))).intValue();
    }

    private static PositiveInteger sum(PositiveInteger[] positiveIntegers) {
        PositiveInteger result = PositiveInteger.ZERO;
        for (PositiveInteger positiveInteger : positiveIntegers) {
            result = result.plus(positiveInteger);
        }
        return result;
    }

    private static String[] split(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private static PositiveInteger[] toPositiveIntegers(String[] values) {
        PositiveInteger[] positiveIntegers = new PositiveInteger[values.length];
        for (int i = 0; i < values.length; i++) {
            positiveIntegers[i] = toPositiveInteger(values[i]);
        }
        return positiveIntegers;
    }

    private static PositiveInteger toPositiveInteger(String value) {
        return new PositiveInteger(value);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

}
