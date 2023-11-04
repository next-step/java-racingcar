package calculator;

import java.util.Objects;

public class Calculator {

    private static final String NEW_LINE = "\n";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        Delimiter delimiter = text.contains(NEW_LINE) ? new CustomDelimiter() : new DefaultDelimiter();
        return sum(delimiter.split(text));
    }

    private static void checkNegativeNumber(int tokenNumber) {
        if (tokenNumber < 0) {
            throw new IllegalArgumentException();
        }
    }

    private static int toNumbers(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static int sum(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            int tokenNumber = toNumbers(token);
            checkNegativeNumber(tokenNumber);
            result += tokenNumber;
        }
        return result;
    }

    private static boolean isNullOrEmpty(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

}
