package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndAddString(String numbersText) {
        if (numbersText == null || numbersText.isEmpty()) {
            return 0;
        }

        String[] numbers;
        int result = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbersText);

        if (m.find()) {
            String customDelimeter = m.group(1);
            numbers = m.group(2).split(customDelimeter);
        } else {
            numbers = numbersText.split(",|:");
        }

        for (String text : numbers) {
            int number = Integer.parseInt(text);
            if (number < 0) {
                throw new RuntimeException();
            }
            result += number;
        }

        return result;
    }
}
