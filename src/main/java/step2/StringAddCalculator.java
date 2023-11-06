package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isBlankOrNull(text)) {
            return 0;
        }

        if (text.contains(",") || text.contains(":")) {
            String[] nums = text.split(",|:");
            return sum(parseInt(nums));
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] nums = m.group(2).split(customDelimiter);
            return sum(parseInt(nums));
        }

        int num = Integer.parseInt(text);

        return num;
    }

    private static int sum(int[] nums) {
        int result = 0;
        for (int num : nums) {
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
}
