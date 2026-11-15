package calculator;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;

        for (String number : input.split(DEFAULT_DELIMITER)) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}
