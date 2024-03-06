package StringAddCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        return Arrays.stream(parseIntArray(getSplitArray(input))).sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int[] parseIntArray(String[] strArray) {
        int size = strArray.length;
        int[] intArray = new int[size];

        for (int i = 0; i < size; i++) {
            intArray[i] = parseInt(strArray[i]);
        }

        return intArray;
    }

    private static String[] getSplitArray(String input) {
        String splitter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            splitter += splitter + '|' + m.group(1);
            return m.group(2).split(splitter);
        }

        return input.split(splitter);
    }

    private static int parseInt(String input) {
        try {
            int parsedInt = Integer.parseInt(input);

            if (parsedInt < 0) {
                throw new NumberFormatException();
            }

            return parsedInt;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }
}
