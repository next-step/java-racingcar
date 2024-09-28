import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String COMMA = ",";
    public static final String DELIMETER = ",|:";
    public static final String CUSTOMDELIMETER = "//(.)\n(.*)";
    public static final int DEFAULTVALUE_OF_NULL_AND_EMPTYSTRING = 0;

    private StringAddCalculator() {
        throw new RuntimeException();
    }

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return DEFAULTVALUE_OF_NULL_AND_EMPTYSTRING;
        }
        return Integer.parseInt(input);
    }

    public static int splitAndSumWithComma(String input) {
        String[] splited = input.split(COMMA);
        return calculateSum(toInt(splited));
    }

    public static int splitAndSumWithCommaOrColon(String input) {
        String[] splited = input.split(DELIMETER);
        return calculateSum(toInt(splited));
    }

    public static int splitWithCustomDelimeter(String input) {
        Matcher m = Pattern.compile(CUSTOMDELIMETER).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return calculateSum(toInt(tokens));
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
        if (Integer.parseInt(s) < 0) {
            throw new RuntimeException();
        }
    }

    private static int calculateSum(int[] splited) {
        int summation = 0;
        for (int num : splited) {
            summation += num;
        }
        return summation;
    }

    private static int[] toInt(String[] splited) {
        int[] numbers = new int[splited.length];
        for (int i = 0; i < splited.length; i++) {
            numbers[i] = Integer.parseInt(splited[i]);
        }
        return numbers;
    }
}
