package stringadditional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionalCalculator {

    private static final String BASIC_SPLIT_REGEX = ",|:";
    private static final String CUSTOM_SPLIT_REGEX = "//(.)\n(.*)";
    private static final String NUMBER_RANGE_REGEX = "[0-9]";

    public int splitAndSum(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int result = 0;
        Matcher matcher = Pattern.compile(CUSTOM_SPLIT_REGEX).matcher(str);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] values = matcher.group(2).split(customDelimiter);
            return splitValueSum(stringToInt(values));
        }

        String[] values = str.split(BASIC_SPLIT_REGEX);
        return splitValueSum(stringToInt(values));
    }

    private int[] stringToInt(String[] values) {
        int[] numbers = new int[values.length];
        for(int i = 0; i < values.length; i++) {
            confirmInputCorrectValue(values[i]);
            numbers[i] = Integer.parseInt(values[i]);
        }

        return numbers;
    }

    private int splitValueSum(int[] values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }

        return result;
    }

    private void confirmInputCorrectValue(String value) {
        if(!value.matches(NUMBER_RANGE_REGEX)) {
            throw new RuntimeException("숫자 이외의 값 또는 음수가 입력되었습니다.");
        }
    }
}
