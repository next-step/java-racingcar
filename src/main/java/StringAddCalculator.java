import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String COMMA = ",";
    public static final String DELIMETER = ",|:";
    public static final String CUSTOMDELIMETER = "//(.)\n(.*)";

    public static int emptyOrNull(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public static int processOneNumberString(String input) {
        return Integer.parseInt(input);
    }

    public static int splitAndSumWithComma(String input) {
        String[] splited = input.split(COMMA);
        int summation = 0;
        for (String s : splited) {
            summation += Integer.parseInt(s);
        }
        return summation;
    }

    public static int splitAndSumWithCommaOrColon(String input) {
        String[] splited = input.split(DELIMETER);
        int summation = 0;
        for (String s : splited) {
            summation += Integer.parseInt(s);
        }
        return summation;
    }

    public static int splitWithCustomDelimeter(String input) {
        Matcher m = Pattern.compile(CUSTOMDELIMETER).matcher(input);
        int summation = 0;
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            for (String token : tokens) {
                summation += Integer.parseInt(token);
            }
            return summation;
        }
        return -1;
    }

    public static void negativeValidation(String input) {
        String[] splited = input.split(COMMA);
        for (String s : splited) {
            if (Integer.parseInt(s) < 0)
            {
                throw new RuntimeException();
            }
        }
    }
}
