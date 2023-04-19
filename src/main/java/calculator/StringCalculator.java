package calculator;

public class StringCalculator {

    public static final int DEFAULT_RESULT = 0;

    public static int calculate(String input) {
        if (!Splitor.isValid(input)) {
            return DEFAULT_RESULT;
        }
        return StringCalculator.sum(Splitor.split(input));
    }

    private static int sum(String[] numbers) {
        Positive result = new Positive(0);
        for (String number : numbers) {
            result = result.add(new Positive(number));
        }
        return result.number();
    }

}
