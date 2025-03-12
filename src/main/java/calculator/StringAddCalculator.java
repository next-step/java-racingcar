package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher m = pattern.matcher(text);
        String delimiter = "[,:]";

        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        String[] numbers = text.split(delimiter);
        int sum = 0;

        for (String s : numbers) {
            int number = Integer.parseInt(s);
            if (number < 0) {
                throw new RuntimeException();
            }
            sum += number;
        }

        return sum;
    }
}
