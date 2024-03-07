package calculator;

import com.sun.javafx.image.IntPixelGetter;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = "[,|:]";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final int DELIMITER_INDEX = 1;
    private static final int TOKEN_INDEX = 2;

    public static int splitAndSum(String text) {
        /*
            1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
            2. 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
            3. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
         */

        // 1) 검증
        // 1-1) 빈 문자열 또는 null 값을 입력할 경우 0을 반환
        // 1-2) 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
        int validateRsltFlag;
        int totalSum = 0;

        validateRsltFlag = validate(text);
        if (validateRsltFlag >= 0) {
            return validateRsltFlag;
        }

        validateNegativeNumberAndThrow(text);
        
        String[] numbers = splitBySeparator(text);
        for (String num : numbers) {
            totalSum += Integer.parseInt(num);
        }

        return totalSum;
    }

    private static String[] splitBySeparator(String text) {
        Matcher customMatcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(text);
        if (customMatcher.find()) {
            return customMatcher.group(TOKEN_INDEX)
                    .split(customMatcher.group(DELIMITER_INDEX));
        }

        return text.split(DEFAULT_SEPARATOR);
    }

    private static void validateNegativeNumberAndThrow(String text) {
        if (text.contains("-")) {
            throw new IllegalArgumentException("Contains a negative number.");
        }
    }

    private static int validate(String text) {
        if (isNullOrBlank(text)) return 0;
        validateNegativeNumberAndThrow(text);
        if (isSingleNumeric(text)) return Integer.parseInt(text);

        return -1;
    }

    private static boolean isSingleNumeric(String text) {
        return text.matches("\\d+");
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }
}