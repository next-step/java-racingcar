package main.study.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final int ZERO = 0;
    public static final String DELIMITER = "[,:]";
    public static final Pattern customDelimeterPattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String strNumber) {
        if (isEmptyOrNull(strNumber)) {
            return ZERO;
        }

        String[] arrayStrNumber = split(strNumber);
        return sum(convertUIntegerNumbers(arrayStrNumber));
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static boolean isEmptyOrNull(String strNumber) {
        return strNumber == null ||  strNumber.isEmpty();
    }

    private static String[] split(String strNumber) {
        Matcher matcher = customDelimeterPattern.matcher(strNumber);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return strNumber.split(DELIMITER);
    }

    private static int[] convertUIntegerNumbers(String[] numbers) {
        int[] ret = new int[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            ret[i] = convertUIntegerNumber(numbers[i]);
        }

        return ret;
    }

    private static int convertUIntegerNumber(String number) {
        int ret = Integer.parseInt(number);

        if (ret < 0) {
            throw new RuntimeException("It is not positive number");
        }

        return ret;
    }
}
