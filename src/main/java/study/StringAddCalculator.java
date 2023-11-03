package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    static String DELIMITER = ",|:";

    public static int add(String s) {

        int sum = 0;

        if(s == null || s.equals("")){
            return 0;
        }
        String[] numbers = s.split(DELIMITER);
        Matcher matcher = Pattern.compile("(\\/\\/)(.*)(\\n)(.*)").matcher(s);
        if(matcher.find()) {
            DELIMITER = matcher.group(2);
            numbers =matcher.group(4).split(DELIMITER);
        }

        for(int i = 0; i < numbers.length; i++) {
          sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}
