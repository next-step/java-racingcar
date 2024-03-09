package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int calculate(String str) {
        if (isEmptyString(str)) {
            return 0;
        }

        int[] numbers = parseStringToInt(splitString(str));

        return sum(numbers);
    }

    private static boolean isEmptyString(String str) {
        return str == null || str.isEmpty();
    }

    private static String[] splitString(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return str.split("[,:]");
    }

    private static int[] parseStringToInt(String[] strings) {
        int[] numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        return numbers;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

}
