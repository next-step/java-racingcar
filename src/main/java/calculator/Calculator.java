package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int calc(String str) {
        if (isBlank(str)) {
            return 0;
        }

        return sum(split(str));
    }


    private static String[] split(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.matches()) {
            String customDelimiter = Pattern.quote(m.group(1));
            String numbersPart = m.group(2);
            return numbersPart.split(customDelimiter);
        } else {
            return str.split("[,:]");
        }
    }

    private static int sum(String[] array) {
        int sum = 0;
        for (String num : array) {
            isNegative(num);
            sum += Integer.parseInt(num);
        }
        return sum;
    }



    private static void isNegative(String num) {
        if (Integer.parseInt(num) < 0) {
            throw new RuntimeException();
        }
    }

    public static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }
}
