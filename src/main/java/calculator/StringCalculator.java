package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\\:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()) {
            delimiter = m.group(1);
            input = m.group(2);
        }

        String[] elements = input.split(delimiter);
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            int now = Integer.parseInt(elements[i]);
            if (now < 0) {
                throw new RuntimeException();
            }
            sum += now;
        }
        return sum;
    }
}
