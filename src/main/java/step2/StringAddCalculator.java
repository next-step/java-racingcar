package step2;

import step2.delimiter.Delimiter;
import step2.delimiter.DelimiterFactory;
import step2.exception.StringAddIllegalArgumentException;

public class StringAddCalculator {
    private static final DelimiterFactory delimiterFactory = new DelimiterFactory();

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        Delimiter delimiter = delimiterFactory.getDelimiter(text);
        String[] splitedString = delimiter.splitFrom(text);
        return calculateSum(splitedString);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

    private static int calculateSum(String[] stringArr) {
        int sum = 0;
        for (String each : stringArr) {
            int num = parseIntFrom(each);
            validateIsNotNegative(num);
            sum += num;
        }
        return sum;
    }

    private static int parseIntFrom(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void validateIsNotNegative(int num) {
        if (num < 0) {
            throw new StringAddIllegalArgumentException();
        }
    }


}
