package study.step02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 객체지향 생활 체조원칙
 * 게터세터 사용 x
 * 한 메서드에 오직 한 단계의 들여쓰기만
 * else 예약어 사용 x
 */

public class StringPlusCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    private static int result;

    public static int splitAndSum(String givenString) {
        if (givenString == null || givenString.isEmpty()) {
            return 0;
        }
        String[] stringTokens = splitWithDelimiter(givenString);
        int[] intTokens = stringTokensToInt(stringTokens);
        if (!verifyPositiveNumber(intTokens)) {
            throw new RuntimeException();
        }

        return sumAll(intTokens);
    }

    private static String[] splitWithDelimiter(String givenString) {

        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(givenString);
        if (matcher.find()) {
            String findDelimiter = matcher.group(1);
            String stringToken = matcher.group(2);
            return stringToken.split(findDelimiter);
        }
        return givenString.split(DEFAULT_DELIMITER);
    }

    private static int[] stringTokensToInt(String[] stringTokens) {
        int[] numbers = new int[stringTokens.length];
        for (int i = 0; i < stringTokens.length; i++) {
            numbers[i] = Integer.parseInt(stringTokens[i]);
        }
        return numbers;
    }
    private static boolean verifyPositiveNumber(int[] intTokens) {
        for (int token: intTokens) {
            if (token < 0) {
                return false;
            }
        }
        return true;
    }

    private static int sumAll(int[] numbers) {
        int sum = 0;
        for(int number: numbers) {
            sum += number;
        }
        return sum;
    }

}
