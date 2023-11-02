package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = "[,:]";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        String[] split = splitText(text);
        return sumSplitText(split);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DELIMITER);
    }

    private static int sumSplitText(String[] split) {
        int sum = 0;
        for (String s : split) {
            int parseInt = getParseInt(s);
            sum += parseInt;
        }

        return sum;
    }

    private static int getParseInt(String s) {
        int parseInt = Integer.parseInt(s);

        if(parseInt < 0) {
            throw new RuntimeException("음수 값이 입력됨" + parseInt);
        }
        return parseInt;
    }
}