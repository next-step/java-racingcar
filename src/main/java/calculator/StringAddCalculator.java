package calculator;

public class StringAddCalculator {

    public static final String REGEX = ",";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int result = 0;
        String[] values = text.split(REGEX);
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }
}
