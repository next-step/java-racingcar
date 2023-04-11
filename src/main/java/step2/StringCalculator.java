package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if (isNullAndBlank(text)) {
            return ZERO;
        }
        return sum(toInts(strSplit(text)));
    }

    private static String[] strSplit(String text) {
        Matcher m = getMatcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split("[,:]");
    }

    private static Matcher getMatcher(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }

    private static boolean isNullAndBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(int[] intValues) {
        int sum = ZERO;

        for (int intValue : intValues) {
            sum += intValue;
        }
        return sum;
    }

    private static int[] toInts(String[] strValues) {
        int[] intValues = new int[strValues.length];
        for (int i = 0; i < strValues.length; i++) {
            int num = toPositiveNumber(strValues[i]);
            intValues[i] = num;
        }
        return intValues;
    }

    private static int toPositiveNumber(String strValue) {
        int num = Integer.parseInt(strValue);
        if (num < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return num;
    }
}
