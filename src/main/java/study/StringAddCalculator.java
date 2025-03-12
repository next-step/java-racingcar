package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIM = ",|:";

    static public int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] tokens;
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        } else {
            tokens = text.split(StringAddCalculator.DELIM);
        }

        return sumStringToken(tokens);
    }

    static private int sumStringToken(String[] tokens) throws RuntimeException {
        return Arrays.stream(tokens)
                .mapToInt(StringAddCalculator::getSingleNumber)
                .sum();
    }

    static private int getSingleNumber(String text) throws RuntimeException {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new RuntimeException("음수가 입력되었습니다." + number);
        }
        return number;
    }
}
