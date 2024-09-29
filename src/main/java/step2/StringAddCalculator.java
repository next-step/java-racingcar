package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static String BASIC_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        boolean checkValidNum = isNum(text);
        if (!checkValidNum) {
            return 0;
        }
        String[] numbers = splitNum(text);
        int sum = sumNum(numbers);
        return sum;
    }

    public static boolean isNum(String text) {
        if (text == null) {
            return false;
        }
        if (text.isEmpty()) {
            return false;
        }
        return true;
    }

    public static String[] splitNum(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(BASIC_DELIMITER);
    }

    public static int sumNum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += checkNegative(number);
        }
        return sum;
    }

    public static int checkNegative(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new RuntimeException();
            }
            return num;
        } catch (NumberFormatException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
