package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static String DEFAULT_DELIMITER = ",|:";
    static String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        int result = 0;

        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = DEFAULT_DELIMITER;

        if (Pattern.matches(CUSTOM_DELIMITER, input)) {
            Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                delimiter = matcher.group(1);
                input = matcher.group(2);
            }
        }

        Pattern pattern = Pattern.compile(delimiter);
        String[] strings = pattern.split(input);

        for (String string: strings) {
            if (isNumeric(string)) {
                Integer parsedInt = Integer.parseInt(string);

                if (parsedInt < 0) {
                    throw new RuntimeException("음수 문자열은 허용되지 않습니다.");
                }
                result += parsedInt;
            }
            else{
                throw new RuntimeException("digit형식의 문자열만 허용됩니다. ex) '1,2,3'");
            }
        }
        return result;
    }

    public static boolean isNumeric(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
