package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {


    public int isEmptyOrNull(String value) {
        return value == null || value.isEmpty() ? 0:-1;
    }

    public String[] split(String s) {
        return s.split("[,:]");
    }

    public int sum(String[] splitResult) {
        int sum = 0;
        for(String s: splitResult) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    public String[] searchCustom(String s) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            String delimiter = m.group(1);
            String str = m.group(2);

            return str.split(delimiter);
        }
        return null;
    }
}
