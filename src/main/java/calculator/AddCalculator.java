package calculator;

import calculator.exception.NegativeNumException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCalculator {

    public static int execute(String str) {
        if (isInValidString(str))
            return 0;

        String[] arr = splitString(str);

        return getSum(arr);
    }

    private static String[] splitString(String str) {
        String[] arr = splitWithCustomDelimiter(str);

        if (arr != null) {
            return arr;
        }

        return str.split(":|,");
    }

    private static String[] splitWithCustomDelimiter(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return null;
    }

    private static boolean isInValidString(String str) {
        if (str == null || str.equals(""))
            return true;
        return false;
    }

    private static int getSum(String[] arr) {
        int sum = 0;
        for (String tmp : arr) {
            sum += parseNum(tmp);
        }
        return sum;
    }

    private static int parseNum(String tmp) {
        int n = Integer.parseInt(tmp);

        checkNegativeNum(n);

        return n;
    }

    private static void checkNegativeNum(int n) {
        if (n < 0)
            throw new NegativeNumException();
    }
}
