package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern STRING_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String data) {
        if (data == null || data.isBlank()) {
            return 0;
        }

        String pattern = findPattern(data);
        if (!pattern.isBlank()) {
            String[] strings = getNumbers(data, pattern);
            int result = 0;
            for (String str : strings) {
                int num = Integer.parseInt(str);
                checkPositive(num);

                result += num;
            }

            return result;
        }

        int aNumber = Integer.parseInt(data);
        checkPositive(aNumber);

        return aNumber;
    }

    private static String findPattern(String data) {
        String delimiter = "";
        Matcher m = STRING_PATTERN.matcher(data);
        if (m.find()) {
            return m.group(1);
        }

        try {
            delimiter = data.split(",|:").length > 0 ? ",|:" : "";
        } catch (Exception e) {
            // nothing to do
        }

        return delimiter;
    }

    private static String[] getNumbers(String data, String pattern) {
        Matcher m = STRING_PATTERN.matcher(data);
        if (m.find()) {
            return m.group(2).split(pattern);
        }

        return data.split(",|:");
    }

    private static void checkPositive(int aNumber) {
        if (aNumber < 0) {
            throw new RuntimeException();
        }
    }
}
