import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String COMMA = ",";
    public static final String DELIMETER = ",|:";
    public static final String CUSTOMDELIMETER = "//(.)\n(.*)";
    public static final int DEFAULT_VALUE_OF_NULL_AND_EMPTYSTRING = 0;
    public static final Pattern pattern = Pattern.compile(CUSTOMDELIMETER);

    private StringAddCalculator() {
        throw new RuntimeException();
    }

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return DEFAULT_VALUE_OF_NULL_AND_EMPTYSTRING;
        }
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return calculateSum(toInt(tokens));
        }
        String[] splited = input.split(DELIMETER);
        return calculateSum(toInt(splited));
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
            numbers[i] = Integer.parseInt(checkDigit(splited[i]));
        }
        return numbers;
    }
    private static String checkDigit(String input) {
        for (char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new RuntimeException();
            }
        }
        return input;
    }
}
