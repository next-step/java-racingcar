package edu.nextstep.camp.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_DELIMITER_EXTRACT_REGEX = "//(.)\n(.*)";
    private static final String SPILT_DELIMITER_REGEX_COMMA_OR_COLON = ",|:";
    private static final Pattern CUSTOM_DELIMITER_EXTRACT_PATTERN = Pattern.compile(CUSTOM_DELIMITER_EXTRACT_REGEX);
    private static final int CUSTOM_DELIMITER_MATCHER_GROUP_IDX = 1;
    private static final int NUMBERS_STRING_MATCHER_GROUP_IDX = 2;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String nums) {
        if (!hasText(nums)) {
            return 0;
        }

        String[] numsArr = splitNums(nums);

        return sumNums(numsArr);
    }

    private static int sumNums(String[] numsArr) {
        return Arrays.stream(numsArr)
                .mapToInt(StringAddCalculator::parseIntNumStr)
                .sum();
    }

    private static int parseIntNumStr(String numStr) {
        int num = Integer.parseInt(numStr);

        if (num < 0) {
            throw new IllegalArgumentException("Number is negative");
        }

        return num;
    }

    private static String[] splitNums(String nums) {
        Matcher matcher = CUSTOM_DELIMITER_EXTRACT_PATTERN.matcher(nums);

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_MATCHER_GROUP_IDX);

            return matcher.group(NUMBERS_STRING_MATCHER_GROUP_IDX)
                    .split(customDelimiter);
        }

        return nums.split(SPILT_DELIMITER_REGEX_COMMA_OR_COLON);
    }

    private static boolean hasText(String nums) {
        return nums != null && !nums.isEmpty();
    }
}
