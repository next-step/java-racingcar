package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int sum(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);

            int sum = 0;
            for (String s : tokens) {
                sum += Integer.parseInt(s);
            }
            return sum;
        }

        String[] strArray = str.split("[,:]");
        int sum = 0;
        for (String s : strArray) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

}
