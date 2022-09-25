package study.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String defaultDelimiter = "[,:]";
    private static final String CustomDelimiterPattern = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        return getSplitForString(text).sumByString();
    }

    private static Boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static SplitForString getSplitForString(String text) {
        Matcher m = Pattern.compile(CustomDelimiterPattern).matcher(text);
        String delimiter = defaultDelimiter;
        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        return new SplitForString(text, delimiter);
    }

    private static boolean isNegative(int i) {
        if (i < 0) {
            throw new RuntimeException("음수를 허용하지 않습니다.");
        }
        return true;
    }

    private static class SplitForString {

        String text;
        String delimiter;

        public SplitForString(String text, String delimiter) {
            this.text = text;
            this.delimiter = delimiter;
        }

        public int sumByString() {
            var strs = text.split(delimiter);

            return Arrays.stream(strs)
                .mapToInt(Integer::parseInt)
                .filter(StringAddCalculator::isNegative)
                .sum();
        }
    }
}
