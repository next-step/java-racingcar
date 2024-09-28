package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.*?)\n(.*)";

    public static int splitAndSum(final String input){
        if (isStringEmpty(input)){
            return 0;
        }
        Integer[] inputSplit = parseInterArray(splitWithDelimiter(input));

        return sumIntegerArray(inputSplit);
    }

    private static Integer sumIntegerArray(Integer[] nums){
        int result = 0;
        for (Integer num : nums) {
            result += num;
        }

        return result;
    }

    private static Integer[] parseInterArray(String[] inputs){
        Integer[] result = new Integer[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            result[i] = parseStringToInt(inputs[i]);
        }

        return result;
    }

    private static String[] splitWithDelimiter(final String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            String customDelimiter = "[" + m.group(1) + "]";
            return m.group(2).split(customDelimiter);
        }

        return input.split(StringCalculator.DELIMITER);
    }

    private static Boolean isStringEmpty(final String input){
        return input == null || input.isBlank();
    }

    private static Integer parseStringToInt(final String input) {
        return Integer.parseInt(input);
    }
}
