package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final int DEFAULT_VALUE = 0;
    public static final int CUSTOM_DELIMITER_MODE = 1;
    public static final int SPLIT_MODE = 2;
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isBlankOrNull(text)) {
            return DEFAULT_VALUE;
        }

        if (text.contains(",") || text.contains(":")) {
            String[] nums = text.split(",|:");
            return sum(parseInt(nums));
        }

        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_MODE);
            String[] nums = m.group(SPLIT_MODE).split(customDelimiter);
            return sum(parseInt(nums));
        }

        int num = Integer.parseInt(text);
        validateNegativeNumber(num);
        return num;
    }

    private static int sum(int[] nums) {
        int result = 0;
        for (int num : nums) {
            validateNegativeNumber(num);
            result += num;
        }
        return result;
    }

    private static int[] parseInt(String[] stringNumber) {
        int[] nums = new int[stringNumber.length];
        for (int i = 0; i < stringNumber.length; i++) {
            nums[i] = Integer.parseInt(stringNumber[i]);
        }

        return nums;
    }

    private static boolean isBlankOrNull(String text) {
        return text == null || text.isBlank();
    }

    private static void validateNegativeNumber(int num) {
        if (num < 0) {
            throw new RuntimeException("음수는 더할 수 없습니다.");
        }
    }

}
