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
    private static final List<String> SEPARATORS = new ArrayList<>(Arrays.asList(",", ":"));

    public static int splitAndSum(String originText) {
        if (isBlank(originText)) {
            return 0;
        }
        String text = addSeparatorAndGetSubString(originText);
        return getSum(text);
    }

    private static int getSum(String text) {
        int result = 0;
        for (String val : getSplitString(text)) {
            int num = Integer.parseInt(val);
            validNegativeNumber(num);
            result += num;
        }
        return result;
    }

    private static String addSeparatorAndGetSubString(String text) {
        Matcher matched = Pattern.compile(REGEX).matcher(text);
        while (matched.find()) {
            SEPARATORS.add(matched.group(1));
            text = getSubString(matched, text);
            matched = Pattern.compile(REGEX).matcher(text);
        }

        return text;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] getSplitString(String text) {
        return text.split(String.join(DELIMITER, SEPARATORS));
    }

    private static String getSubString(Matcher matched, String text){
        int idx = text.indexOf(SLASH);
        return text.substring(0, idx) + text.substring(idx + matched.group(1).length() + 3);
    }

    private static void validNegativeNumber(int num) {
        if (num < 0) throw new RuntimeException("Contains negative numbers.");
    }
}
