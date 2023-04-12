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
        int result = 0;
        for (String number : numbers) {
            result += new Positive(number).number();
        }
        return result;
    }

}
