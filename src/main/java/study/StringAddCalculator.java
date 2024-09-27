package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final static String  CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private final static String  DELIMITER = "[,:]";
    private final static String NUMBER_PATTERN = "[+-]?\\d*(\\.\\d+)?";

    public static int splitAndSum(String targetStr) {
        if (targetStr == null || targetStr.isEmpty()) {
            return 0;
        }
        List<String> elements = splitTargetString(targetStr);

        validateTargetString(elements);

        return sumElements(elements);
    }

    private static void validateTargetString(List<String> elements) {
        elements.forEach(StringAddCalculator::checkElement);
    }
    private static void checkElement(String element) {
        // 숫자 이면서 0보다큰(정수)
        if(element.matches(NUMBER_PATTERN) && Integer.parseInt(element) >= 0) {
            return ;
        }
       throw new IllegalArgumentException("invalid element");
    }
    private static List<String> splitTargetString(String targetStr) {
        //split string with custom delimiter
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(targetStr);

        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }
        //split string with defined delimiter(, : )
        return Arrays.asList(targetStr.split(DELIMITER));
    }
    private static int sumElements(List<String> elements) {
        return  elements.stream().mapToInt(Integer::valueOf).sum();
    }
}