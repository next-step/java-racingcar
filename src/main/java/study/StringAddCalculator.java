package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

class StringAddCalculator {

    private static final String SPLIT_REGEX_FOR_SUM = "[,:]";
    private static final String DELIMITER_REGEX_FOR_SUM = "//(.)\n(.*)";

    private StringAddCalculator() {
        throw new IllegalStateException("Utility class");
    }
    public static int sum(String inputNumbers){
        if(isBlankOrNull(inputNumbers)){
            return 0;
        }
        return toIntStream(toStringArray(inputNumbers)).sum();
    }

    private static String[] toStringArray(String inputNumbers){
        Matcher m = Pattern.compile(DELIMITER_REGEX_FOR_SUM).matcher(inputNumbers);
        if(m.find()){
            return m.group(2).split(m.group(1));
        }
        return inputNumbers.split(SPLIT_REGEX_FOR_SUM);
    }

    private static IntStream toIntStream(String[] inputNumbers) {
        return Arrays.stream(inputNumbers).mapToInt(Integer::parseInt);
    }

    private static boolean isBlankOrNull(String inputNumbers) {
        return inputNumbers == null || inputNumbers.isEmpty();
    }

}
