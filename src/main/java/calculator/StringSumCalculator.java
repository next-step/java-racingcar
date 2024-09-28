package calculator;

import java.util.Objects;

public class StringSumCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = ",|;";
    private static final String CUSTOM_DELIMTER_REGEX = "^//.*\\n.*";
    private static final String ONLY_POSITIVE_NUMBER_REGEX = "^[0-9]*$";

    public static int splitAndSum(String value) {
        int result = 0;

        if (isStringInvalid(value)) {
            return result;
        }

        return sum(toInts(splitNumbersWithDelimiter(value)));
    }

    public static int sum(int[] intNumbers) {
        int result = 0;
        for (int intNum : intNumbers) {
            result += intNum;
        }
        return result;
    }

    private static String[] splitNumbersWithDelimiter(String numbers) {
        final String FRONT_OF_CUSTOM_DELIMITER = "//";
        final String END_OF_CUSTOM_DELIMITER = "\n";

        if (numbers.matches(CUSTOM_DELIMTER_REGEX)) {
            String[] delimiterAndNumbers = numbers.split(END_OF_CUSTOM_DELIMITER);
            String customDelimiter = delimiterAndNumbers[0].substring(FRONT_OF_CUSTOM_DELIMITER.length());
            return delimiterAndNumbers[1].split(customDelimiter);
        }

        return numbers.split(DEFAULT_DELIMITER_REGEX);
    }

    private static boolean isStringInvalid(String s) {
        return Objects.isNull(s) || s.isEmpty();
    }

    private static int[] toInts(String[] strNums) {
        int[] intNums = new int[strNums.length];
        for (int i=0; i< strNums.length; i++) {
            checkOnlyPositiveNumber(strNums[i]);

            intNums[i] = Integer.parseInt(strNums[i]);
        }
        return intNums;
    }

    private static void checkOnlyPositiveNumber(String strNumber) {
        if (!strNumber.matches(ONLY_POSITIVE_NUMBER_REGEX)) {
            throw new RuntimeException("숫자 외 문자, 음수는 입력할 수 없습니다.");
        }
    }
}
