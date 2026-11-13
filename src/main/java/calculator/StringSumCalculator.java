package calculator;

public class StringSumCalculator {

    public static final String DEFAULT_SEPARATOR = ",|:";

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;
        for (String s : input.split(DEFAULT_SEPARATOR)) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}
