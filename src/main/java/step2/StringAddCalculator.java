package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    static private final int NULL_OR_BLANK = 0;
    static public int splitAndSum(String text) {
        if (isTextNullOrBlank(text)) {
            return NULL_OR_BLANK;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            List<String> tokens = split(m.group(2), customDelimiter);
            return sum(tokens);
        }
        return sum(split(text, ",|:"));
    }

    static private boolean isTextNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }

    static private List<String> split(String str,String delimiter) {
        return Arrays.asList(str.split(delimiter));
    }

    static private int sum(List<String> tokens) {
        int result = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException("음수는 계산할 수 없습니다.");
            }
            result += number;
        }
        return result;
    }

}
