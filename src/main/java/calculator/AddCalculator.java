package calculator;

import calculator.exception.NegativeNumException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCalculator {

    private static final String NORMAL_DELIMITER = ":|,";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);

    public static int execute(String str) {
        if (isInValidString(str))
            return 0;

        return getSum(splitString(str));
    }

    private static String[] splitString(String str) {
        String[] arr = splitWithCustomDelimiter(str);

        if (arr != null) {
            return arr;
        }

        return str.split(NORMAL_DELIMITER);
    }

    private static String[] splitWithCustomDelimiter(String str) {
        Matcher m = pattern.matcher(str);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return null;
    }

    private static boolean isInValidString(String str) {
        return (str == null || str.equals(""));
    }

    private static int getSum(String[] arr) {
        int sum = 0;
        for (String tmp : arr) {
            sum += parseInteger(tmp);
        }
        return sum;
    }

    private static int parseInteger(String tmp) {
        int n = 0;

        try {
            n = Integer.parseInt(tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkNegativeNum(n);

        return n;
    }

    private static void checkNegativeNum(int n) {
        if (n < 0)
            throw new NegativeNumException();
    }
}
