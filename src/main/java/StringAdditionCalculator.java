import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int sum(String input) {
        return sum(toInteger(split(input)));
    }

    private static Integer[] toInteger(String[] splits) {
        Integer[] nums = new Integer[splits.length];
        for (int i = 0; i < splits.length; i++) {
            int num = Integer.parseInt(splits[i]);
            if (num < 0) {
                throw new RuntimeException("negative number error");
            }
            nums[i] = num;
        }
        return nums;
    }


    private static int sum(Integer[] splits) {
        int sum = 0;
        for (Integer num : splits) {
            sum += num;
        }
        return sum;
    }

    private static String[] split(String input) {
        if (input == null || input.isEmpty()) {
            return new String[]{"0"};
        }

        String[] split = input.split(DEFAULT_DELIMITER);
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            split = m.group(2).split(customDelimiter);
        }
        return split;
    }
}
