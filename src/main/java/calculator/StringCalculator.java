package calculator;

public class StringCalculator {
    private static final String BLANK = " ";
    public int calculate(String input) {
        isEmpty(input);

        String[] source = toStringArray(input);
        return 0;
    }

    private void isEmpty(final String input) {
        if (input == null || input.equals(BLANK)) {
            throw new IllegalArgumentException("wrong input value");
        }
    }

    String[] toStringArray(final String input) {
        return input.split(BLANK);
    }
}
