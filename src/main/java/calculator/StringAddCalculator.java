package calculator;

import util.NumberUtil;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = CUSTOM_DELIMITER.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return sum(m.group(2).split(customDelimiter));
        }
        return sum(text.split(",|:"));

    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(NumberUtil::getPositiveInteger)
                .sum();
    }

}
