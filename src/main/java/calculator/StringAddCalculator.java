package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS = "[,;]";
    private static final Pattern DELIMITER_REGEX_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int PATTERN_MATCHING_GROUP_FIRST_INDEX = 1;
    private static final int PATTERN_MATCHING_GROUP_SECOND_INDEX = 2;


    public static int run(String str) {
        if (isEmptyOrNull(str)) {
            return 0;
        }
        String[] splitStrings = split(str);
        int[] numbers = parseStringToInt(splitStrings);
        return sum(numbers);
    }

    private static boolean isEmptyOrNull(String str) {
        return str == null || str.isEmpty();
    }

    private static String[] split(String str) {
        Matcher m = DELIMITER_REGEX_PATTERN.matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(PATTERN_MATCHING_GROUP_FIRST_INDEX);
            return m.group(PATTERN_MATCHING_GROUP_SECOND_INDEX).split(customDelimiter);
        }
        return str.split(DEFAULT_DELIMITERS);
    }

    private static int[] parseStringToInt(String[] strs) {
        int[] ints = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            ints[i] = parseInt(strs[i]);
        }
        return ints;
    }

    private static int parseInt(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number < 0) throw new RuntimeException("음수는 허용하지 않습니다.");
        return number;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }

}
