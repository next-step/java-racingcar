import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (matcher.matches()) {
            Integer[] numbers = toInts(split(matcher.group(2), matcher.group(1)));
            return sum(numbers);
        }

        Integer[] numbers = toInts(split(input, DEFAULT_DELIMITER_REGEX));
        return sum(numbers);
    }

    public static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    public static Integer[] toInts(String[] inputArray) {
        Integer[] result = new Integer[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            result[i] = Integer.parseInt(inputArray[i]);
        }
        return result;
    }

    public static Integer sum(Integer[] numbers) {
        int result = 0;
        for (int num : numbers) {
            if (num < 0) {
                throw new RuntimeException("Negative input!");
            }
            result += num;
        }
        return result;
    }
}
