package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";
    private static final String SPLIT_OR = "|";
    private static final String DELIMITER = DELIMITER_COMMA + SPLIT_OR + DELIMITER_COLON;

    public static int splitAndSum(String string) {
        if (nullOrEmpty(string)) return 0;
        String[] stringArray = splitByDelimiter(string);
        int[] intArray = intArrayFromStringArray(stringArray);
        return intArraySum(intArray);
    }

    private static String[] splitByDelimiter(String string) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);
        if (m.find()) return m.group(2).split(m.group(1));
        return string.split(DELIMITER);
    }

    private static int intArraySum(int[] intArray) {
        int sum = 0;
        for (int j : intArray) sum += j;
        return sum;
    }

    private static int[] intArrayFromStringArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) intArray[i] = intFromString(stringArray[i]);
        return intArray;
    }

    private static int intFromString(String string) {
        int result = Integer.parseInt(string);
        if (!positive(result)) throw new RuntimeException();
        return result;
    }

    private static boolean nullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    private static boolean positive(int integer) {
        return integer >= 0;
    }

}
