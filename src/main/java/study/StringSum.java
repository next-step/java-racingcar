package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSum {


    public int sumStringByDelimiter(String data) {
        String delimiter = ",|:";

        if (data.startsWith("//")) {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(data);
            if (m.find()) {
                delimiter = m.group(1);
                data = m.group(2);
            }
        }

        return Arrays.stream(data.split(delimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
