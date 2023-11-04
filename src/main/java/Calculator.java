import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int cal(String input) {
        if (isEmptyOrNull(input)) {
            return 0;
        }

        if (input.contains(",") || input.contains(":")) {
            return toInt(splitByCommaOrColon(input));
        }

        if (input.contains("//") && input.contains("\n")) {
            return toInt(calForCustomDelimiter(input));
        }

        return toInt(splitByCommaOrColon(input));
    }

    private static String[] splitByCommaOrColon(String input) {
        return input.split(",|:");
    }

    private static boolean isEmptyOrNull(String input) {
        return input == null || input.isBlank();
    }

    private static int toInt(String[] strings) {
        int sum = 0;
        for (String string : strings) {
            isStringValid(string);
            sum += Integer.parseInt(string);
        }

        return sum;
    }

    private static void isStringValid(String string) {
        if (Integer.parseInt(string) < 0 || !isNumeric(string)) {
            throw new IllegalArgumentException("The input string is not valid");
        }
    }

    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static String[] calForCustomDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        return new String[0];
    }
}
