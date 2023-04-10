package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    
    static int splitAndSum(String text) {
        int result = 0;
        if (isBlank(text)) {
            return result;
        }
        
        String[] tokens = splitByPattern(text);
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException("Negative Number !");
            }

            result += Integer.parseInt(token);
        }

        return result;
    }


    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    
    private static String[] splitByPattern(String text) {
        String[] tokens = text.split(",|:");
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            tokens = matcher.group(2).split(customDelimiter);
        }

        return tokens;
    }
}
