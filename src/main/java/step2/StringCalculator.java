package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int addOperation(String text) {
        if (text == null)
            return 0;
        String[] numbers = split(text);
        int result = add(numbers);
        return result;
    }

    private static String[] split(String text) {
        String regex = ",|:";
        Matcher m = Pattern.compile("//(.)\\n(.*)").matcher(text);
        if (m.find()) {
            String separator = m.group(1);
            regex = regex + "|" + separator;
            text = m.group(2);
        }
        return text.split(regex);
    }

    private int add(String[] textArray) {
        return Arrays.stream(textArray).mapToInt(i -> textCheck(i)).sum();
    }

    public int textCheck(String text) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(text);
    }
}
