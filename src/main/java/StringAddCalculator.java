import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int calculateSum(String strValue) {
        if (isEmptyOrNull(strValue))
            return 0;

        return split(StringsToInts(getStringValues(strValue, getMatcher(strValue))));
    }

    private static String getDelimiter(Matcher m) {
        if (m.find()) {
            return m.group(1);
        }
        return ",|:";
    }

    private static String[] getStringValues(String strValue, Matcher m) {
        String delimiter = getDelimiter(getMatcher(strValue));
        if (m.find()) {
            return m.group(2).split(delimiter);
        }
        return strValue.split(delimiter);
    }

    private static Matcher getMatcher(String strValue) {
        return Pattern.compile("//(.)\n(.*)").matcher(strValue);
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
            isNegative(numbers[i]);
        }
        return numbers;
    }

    private static void isNegative(int number) {
        if(number < 0) {
            throw new RuntimeException();
        }
    }

    private static boolean isEmptyOrNull(String strValue) {
        return strValue == null || strValue.isEmpty();
    }
}
