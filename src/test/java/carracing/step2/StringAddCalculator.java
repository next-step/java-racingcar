package carracing.step2;

import java.util.StringTokenizer;

public class StringAddCalculator {

    private static final char CUSTOM_DELIMITER_STARTER = '/';

    public static int splitAndSum(String originText) {
        String text = originText;
        if (text == null || text.isEmpty()) {
            return 0;
        }

        StringBuilder delimiter = new StringBuilder(",:");
        if (text.charAt(0) == CUSTOM_DELIMITER_STARTER) {
            int stringStartIdx = getStringStartIdx(text);
            delimiter.append(text, 2, stringStartIdx - 1);
            text = text.substring(stringStartIdx);
        }

        return addAllNumber(text, delimiter);
    }

    private static int addAllNumber(String text, StringBuilder delimiter) {
        StringTokenizer tokens = new StringTokenizer(text, delimiter.toString());
        int result = 0;
        while (tokens.hasMoreTokens()) {
            int number = getNumberOfParsingToken(tokens);
            result += number;
        }
        return result;
    }

    private static int getStringStartIdx(String text) {
        int idx = 2;
        while (text.charAt(idx) != '\n') {
            idx += 1;
        }
        return idx + 1;
    }

    private static int getNumberOfParsingToken(StringTokenizer tokens) {
        int number = Integer.parseInt(tokens.nextToken());
        if (number < 0) {
            throw new RuntimeException("음수 발생");
        }
        return number;
    }

}
