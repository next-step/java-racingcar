package calculator;

import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        String DEFAULT_DELIMETER = ",|:";
        Pattern pattern = Pattern.compile(DEFAULT_DELIMETER);
        int result = 0;

        if (input == null || input.isEmpty()) {
            return 0;
        }

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
