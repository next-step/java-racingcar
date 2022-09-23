package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C {
    public static int calculator(String text) {
        if (text == null || text.equals("")) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] arr = m.group(2).split(customDelimiter);
            int result = 0;
            for (String str : arr) {
                int number = Integer.parseInt(str);
                if (number < 0) {
                    throw new RuntimeException();
                }
                result += number;
            }
            return result;
        } else {
            String[] arr = text.split(",|:");
            int result = 0;
            for (String str : arr) {
                int number = Integer.parseInt(str);
                if (number < 0) {
                    throw new RuntimeException();
                }
                result += number;
            }
            return result;
        }
    }
}
