package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = "|";
    private static final String SLASH = "//";
    private static final String REGEX = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public static int splitAndSum(String originText) {
        if (isBlank(originText)) {
            return 0;
        }

        return getSum(originText);
    }

    private static int getSum(String originText) {
        List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));
        String text = addSeparatorAndGetSubString(originText, separators);

        int result = 0;
        for (String val : getSplitString(text, separators)) {
            int num = Integer.parseInt(val);
            validNegativeNumber(num);
            result += num;
        }
        return result;
    }

    private static String addSeparatorAndGetSubString(String text, List<String> separators) {
        Matcher matched = PATTERN.matcher(text);
        if (matched.find()) {
            separators.add(matched.group(1));
            text = getSubString(matched, text);
        }
        return text;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] getSplitString(String text, List<String> separators) {
        return text.split(String.join(DELIMITER, separators));
    }

    private static String getSubString(Matcher matched, String text){
        int idx = text.indexOf(SLASH);
        return text.substring(0, idx) + text.substring(idx + matched.group(1).length() + 3);
    }

    private static void validNegativeNumber(int num) {
        if (num < 0) throw new RuntimeException("Contains negative numbers.");
    }
}
