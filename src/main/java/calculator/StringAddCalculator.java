package calculator;

public final class StringAddCalculator {

    public static int splitAndSum(final String input) {
        String[] split = split(input);

        return sum(split);
    }

    private static String[] split(final String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        String delimiter = ",|:";
        String[] split = input.split(delimiter);

        return split;
    }

    private static int sum(final String[] split) {
        int sum = 0;
        for (String number : split) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
