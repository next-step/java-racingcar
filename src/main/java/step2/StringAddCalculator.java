package step2;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final int MIN_NUMBER = 0;
    private static final int MIN_SIZE = 1;

    public static int splitAndSum(final String inputValue) {
        if(isBlank(inputValue)) {
            return 0;
        }

        return sum(inputValue);
    }

    private static boolean isBlank(final String inputValue) {
        return inputValue == null || inputValue.isEmpty();
    }

    private static int sum(final String inputValue) {
        String[] values = inputValue.split(DELIMITER);
        int sum = 0;
        for(String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }
}
