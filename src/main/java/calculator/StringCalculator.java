package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String regex = "[,:]";
    private static final String custom_delimiter = "//(.)\n(.*)";

    public static int cal(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return sum(split(str));
    }

    private static String[] split(String str) {
        Matcher m = Pattern.compile(custom_delimiter).matcher(str);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return str.split(regex);
    }

    private static int sum(String[] strings) {
        int result = 0;
        for (String s : strings) {
            result += toInts(s);
        }
        return result;
    }

    private static int toInts(String s) {
        int i = Integer.parseInt(s);
        if(i < 0) {
            throw new RuntimeException("음수는 허용되지 않습니다.");
        }
        return i;
    }
}
