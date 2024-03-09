package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int calculate(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String[] strings = split(str);
        int[] numbers = parseStringToInt(strings);

        return sum(numbers);
    }

    private static String[] split(String str) {
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
