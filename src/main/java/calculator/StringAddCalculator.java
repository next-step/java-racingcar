package calculator;

public class StringAddCalculator {
    public int splitAndSum(final String input) {
        if (isEmpty(input)) {
            return 0;
        }

        return -1;
    }

    private boolean isEmpty(final String input) {
        return input == null || input.isEmpty();
    }
}
