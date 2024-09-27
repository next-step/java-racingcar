package step2;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final int MIN_NUMBER = 0;

    public static int splitAndSum(final String inputValue) {
        if(isBlank(inputValue)) {
            return 0;
        }

        return 0;
    }

    private static boolean isBlank(final String inputValue) {
        return inputValue == null || inputValue.isEmpty();
    }
}
