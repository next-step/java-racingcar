package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String targetStr) {
        if (targetStr == null || targetStr.isEmpty()) {
            return 0;
        }
        // split
        List<String> elements = splitTargetString(targetStr);
        // validate
        validateTargetString(elements);
        // sum
        return sumElements(elements);
    }

    private static void validateTargetString(List<String> elements) {
        for (String element : elements) {
            checkElement(element) ;
        }
    }
    private static void checkElement(String element) {
        // 숫자 이면서 0보다큰(정수)
        if(element.matches("[+-]?\\d*(\\.\\d+)?") && Integer.parseInt(element) >= 0) {
            return ;
        }
       throw new RuntimeException();
    }
    private static List<String> splitTargetString(String targetStr) {
        //split string with custom delimiter
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(targetStr);

        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }
        //split string with defined delimiter(, : )
        return Arrays.asList(targetStr.split("[,:]"));
    }
    private static int sumElements(List<String> elements) {
        int sum = 0 ;
        for (String element : elements) {
            sum += Integer.parseInt(element);
        }
        return sum;
    }
}