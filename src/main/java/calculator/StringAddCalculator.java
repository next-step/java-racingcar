package calculator;

public final class StringAddCalculator {

    public static int splitAndSum(final String input) {
        String delimiter = ",|:";
        String[] split = input.split(delimiter);

        int sum = 0;
        for (String number : split) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
