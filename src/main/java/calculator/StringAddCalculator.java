package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS = "[,;]";

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
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return str.split(DEFAULT_DELIMITERS);
    }

    private static int[] parseStringToInt(String[] strs) {
        int[] ints = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }
        return ints;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }

}
