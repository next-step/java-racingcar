package study.step2;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = ",|:";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] numbers = text.split(DEFAULT_SEPARATOR);

        int sum = 0;
        for (String number : numbers) {
            if(!number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }
}
