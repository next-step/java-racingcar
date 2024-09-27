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
        return calculateSum(splited);
    }

    public static int splitAndSumWithCommaOrColon(String input) {
        String[] splited = input.split(DELIMETER);
        return calculateSum(splited);
    }

    public static int splitWithCustomDelimeter(String input) {
        Matcher m = Pattern.compile(CUSTOMDELIMETER).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return calculateSum(tokens);
        }
        return -1;
    }

    public static void negativeValidation(String input) {
        String[] splited = input.split(COMMA);
        for (String s : splited) {
            validNegativeNumberString(s);
        }
    }

    private static void validNegativeNumberString(String s) {
        if (Integer.parseInt(s) < 0)
        {
            throw new RuntimeException();
        }
    }

    private static int calculateSum(String[] splited) {
        int summation = 0;
        for (String s : splited) {
            summation += Integer.parseInt(s);
        }
        return summation;
    }

}
