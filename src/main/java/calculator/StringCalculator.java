package calculator;

public class StringCalculator {
    public StringCalculator() {
    }

    public int splitAndSum(String text) {
        if (this.isBlank(text)) {
            return 0;
        }

        final StringOperator stringOperator = new StringOperator(text);

        return sum(stringOperator.split());
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private int sum(String[] values) {
        final Positive positive = new Positive();
        final int[] positives = positive.toPositiveInts(values);

        return positive.sumPositiveNumbers(positives);
    }

}
