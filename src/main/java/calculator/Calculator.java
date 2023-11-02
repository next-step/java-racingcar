package calculator;

import java.util.Objects;

public class Calculator {

    public static final String LINE_BREAKING = "\n";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        if (text.contains(LINE_BREAKING)) {
            Delimiter delimiter = new CustomDelimiter();
            return getAdditionResult(delimiter.getTokens(text));
        }

        Delimiter delimiter = new DefaultDelimiter();
        return getAdditionResult(delimiter.getTokens(text));
    }

    private static void checkNegativeNumber(int tokenNumber) {
        if (tokenNumber < 0) {
            throw new RuntimeException();
        }
    }

    private static int toNumbers(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static int getAdditionResult(String[] tokens) {
        int additionResult = 0;
        for (String token : tokens) {
            int tokenNumber = toNumbers(token);
            checkNegativeNumber(tokenNumber);
            additionResult += tokenNumber;
        }
        return additionResult;
    }

    private static boolean isNullOrEmpty(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

}
