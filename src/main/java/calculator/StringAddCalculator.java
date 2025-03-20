package calculator;

public class StringAddCalculator {

    private StringAddCalculator() {

    }

    public static int sum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        final String[] numbers = StringParser.split(text);
        final PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);
        return positiveNumbers.sum();
    }
}
