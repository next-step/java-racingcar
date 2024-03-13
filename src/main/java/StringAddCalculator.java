import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String BASIC_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String OR_DELIMITER = "|";
    private static final int EMPTY_NULL_RETURN_VALUE = 0;
    private static final int DELIMITER_FIRST_VALUE= 1;
    private static final int DELIMITER_SECOND_VALUE = 2;

    public static int calculateSum(String strValue) {
        if(isNullOrEmpty(strValue)) {
            return EMPTY_NULL_RETURN_VALUE;
        }

        String[] values = getStringValues(strValue);

        return split(StringsToInts(values));
    }

    private static boolean isNullOrEmpty(String strValue) {
        return strValue == null || strValue.isBlank();
    }

    private static String[] getStringValues(String strValue) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(strValue);
        if(matcher.find()) {
            String delimiter = BASIC_DELIMITER + OR_DELIMITER + matcher.group(DELIMITER_FIRST_VALUE);
            return matcher.group(DELIMITER_SECOND_VALUE).split(delimiter);
        }
        return strValue.split(BASIC_DELIMITER);
    }

    private static int split(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] StringsToInts(String[] values) throws RuntimeException {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
            checkNegative(numbers[i]);
        }
        return numbers;
    }
  
    private static void checkNegative(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("양수만 입력해주세요.");
        }
    }
}
