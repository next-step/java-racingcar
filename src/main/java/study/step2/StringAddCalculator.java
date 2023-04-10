package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    static int splitAndSum(String text) {

        if (text == null) return 0;
        if (text.isEmpty()) return 0;

        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return sum(tokens);
        } else {
            return sum(split(text));
        }

    }

    static String[] split(String text) {

        return text.split(",|:");
    }

    static int sum(String[] tokens) {

        int sum = 0;
        int element;
        for (String token : tokens) {
            try {
                element = Integer.parseInt(token);
                if (!isZeroOrPositive(element)) {
                    throw new RuntimeException();
                }
                sum += element;
            } catch (NumberFormatException e) {
                throw new RuntimeException();
            }
        }
        return sum;
    }

    static boolean isZeroOrPositive(int num) {
        return num >= 0;
    }


}
