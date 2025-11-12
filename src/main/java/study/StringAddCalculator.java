package study;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if(StringUtils.isBlank(text)) {
            return 0;
        }

        if(text.contains(",") || text.contains(":")) {
            int sum          = 0;
            String[] numbers = text.split("[,:]");

            for(String number : numbers) {
                if(Integer.parseInt(number) < 0) {
                    throw new RuntimeException(" RuntimeException 예외 발생");
                }

                sum += Integer.parseInt(number);
            }

            return sum;
        }

        if(text.contains("//") || text.contains("\n")) {
            int sum = 0;
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
            if(m.find()) {

                String customDelimiter = m.group(1);
                String[] tokens = m.group(2).split(customDelimiter);

                for(String token : tokens) {
                    sum += Integer.parseInt(token);
                }

                return sum;
            }
        }



        return Integer.parseInt(text);
    }
}
