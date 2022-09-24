package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator2 {
    public static int splitAndAdd(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return add(split(input));
    }

    public static int add(String[] strNumbers) {
        int sum = 0;

        for (String strNumber : strNumbers) {
            sum += parseInt(strNumber);
        }

        return sum;
    }

    public static int parseInt(String maybeNumberString) {
        try {
            int parsedValue = Integer.parseInt(maybeNumberString);

            if (parsedValue < 0) {
                throw new RuntimeException();
            }

            return parsedValue;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static int add(Integer[] numbers) {
        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static String[] split(String input) {
        return input.split(",|:");
    }

    public static String extractDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            return m.group(1);
        }

        return null;
    }
}
