import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int EMPTY_INPUT_RESULT = 0;

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEXP);

    public static int splitAndSum(String text){

        if(checkEmptyOrNull(text)) return EMPTY_INPUT_RESULT;

        List<String> tokens= List.of(stringSplit(text));
        checkNegativeNum(tokens);

        return sum(tokens);
    }

    private static String[] stringSplit(String text){
        // 숫자를 직접 사용하는 매직 넘버 지양하기
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static boolean checkEmptyOrNull(String text){
        return text == null || text.isBlank();
    }

    private static void checkNegativeNum(List<String> text){
        boolean flag = text.stream().mapToInt(Integer::parseInt).anyMatch(n -> n < 0);
        if(flag)
            throw new RuntimeException("Negative Number is not allowed");
    }

    private static int sum(List<String> tokens){
        return tokens.stream().mapToInt(Integer::parseInt).sum();
    }

}
