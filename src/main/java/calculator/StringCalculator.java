package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER = ",|\\:";

    public static int calculate(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        String[] elements = removeCustomDelimiter(input).split(getDelimiter(input));
        return sum(transfer(elements));
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String getDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    private static String removeCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(2);
        }
        return text;
    }

    private static Integer[] transfer(String[] elements) {
        Integer[] nums = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++) {
            nums[i] = parseInt(elements[i]);
        }
        return nums;
    }

    private static int sum(Integer[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            checkPositive(num);
            sum += num;
        }
        return sum;
    }

    private static void checkPositive(int num) {
        if (num < 0) {
            throw new RuntimeException();
        }
    }
}
