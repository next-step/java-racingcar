package step2;

public class StringAddCalculator {

    private static final int DEFAULT_RETURN_VALUE = 0;
    private static final String MINUS = "-";

    public static int splitAndSum(final String input) {
        if (isBlank(input)) {
            return DEFAULT_RETURN_VALUE;
        }
        validateNegativeNumber(input);

        int[] splitNumbers = SplitNumber.splitNumbers(input);

        return SumNumber.sum(splitNumbers);
    }

    private static boolean isBlank(final String input) {
        return input == null || input.isEmpty();
    }

    private static void validateNegativeNumber(final String input) {
        if (input.contains(MINUS)) {
            throw new IllegalArgumentException("Not Allowed Negative Exception");
        }
    }
}