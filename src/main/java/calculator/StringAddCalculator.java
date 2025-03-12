package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isNullEmpty(text)) {
            return 0;
        }

        if(isSingleDigitNumber(text)){
            return Integer.parseInt(text);
        }

        List<String> result = extractDelimiterAndNumbers(text);
        String delimiter = result.get(0);
        String numbers = result.get(1);

        String[] tokens = splitText(numbers, delimiter);
        return sumTokens(tokens);
    }

    private static boolean isNullEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static boolean isSingleDigitNumber(String text) {
        return text.length() == 1 && Character.isDigit(text.charAt(0));
    }

    private static void checkForNegativeNumbers(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 사용할수없습니다.");
        }
    }

    private static List<String> extractDelimiterAndNumbers(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        List<String> result = new ArrayList<>();

        if (m.find()) {
            result.add(Pattern.quote(m.group(1)));
            result.add(m.group(2));
        } else {
            result.add(",|:");
            result.add(text);
        }
        return result;
    }

    private static String[] splitText(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                int number = Integer.parseInt(token);
                checkForNegativeNumbers(number);
                sum += number;
            }
        }
        return sum;
    }

}
