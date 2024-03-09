package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int splitAndSum(String text) {
        //String REGEX_DELIMITER = "([,:])|(//(.)\n(.*))";
        String REGEX_DELIMITER = "//(.*)\n(.*)";
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }
        Matcher matcher = Pattern.compile(REGEX_DELIMITER).matcher(text);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            System.out.println("delimiter = " + delimiter);
            String[] strings = matcher.group(2).split(delimiter);
            int result = 0;
            for (String string : strings) {
                System.out.println("string = " + string);
                result += Integer.parseInt(string);
            }
            return result;
        }
        String[] strings = text.split(",|:");
        int result = 0;
        for (String string : strings) {
            System.out.println("string = " + string);
            result += Integer.parseInt(string);
        }
        return result;
    }
}
