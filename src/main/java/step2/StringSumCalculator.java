package step2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("String Sum Calculator");
        System.out.println("Basic Delimiters are \",\" and \";\"");
        System.out.println("Enter \"//\" and \"\\n\" followed by your custom delimiter, if wanted (ex. \"//;\\n1;2;3\")");
        System.out.println("Enter the String below (ex. \"1,2,3\")");
        String input = SCANNER.nextLine();
        int result = calculateStringWithSumOnly(input);
        System.out.println("result : " + result);
    }

    public static int calculateStringWithSumOnly(String input){

        if(input.isEmpty())
            return 0;

        if(hasCustomDelimiter(input)){
            String customDelimiter = getCustomDelimiter(input);
            String stringExpression = getStringWithoutCustomDelimiter(input);
            String[] stringArray = splitValuesByCustomDelimiter(customDelimiter, stringExpression);
            return sum(stringArray);
        }

        String[] stringArray = splitWithCommaAndColon(input);
        return sum(stringArray);
    }


    private static String[] splitWithCommaAndColon(String value) {
        return value.split("[,|:]");
    }

    private static int sum(String[] valueArray) {
        int result = 0;
        for (String value : valueArray) {
            checkInputAvailable(value);
            result += Integer.parseInt(value);
        }
        return result;
    }

    private static String getCustomDelimiter(String value) {
        Pattern pattern = Pattern.compile("//(.)\\n*");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            System.out.println("==============");
            System.out.println(matcher.group(1));
            return matcher.group(1);
        }
        return null;
    }

    private static void checkInputAvailable(String value) {
        if (!value.matches("\\d+")) {
            throw new RuntimeException();
        }
    }

    private static Boolean hasCustomDelimiter(String value) {
        return !Character.isDigit(value.charAt(0));
    }

    private static String getStringWithoutCustomDelimiter(String value) {
        return value.substring(5);
    }

    private static String[] splitValuesByCustomDelimiter(String delimiter,
                                                         String value) {
        return value.split(delimiter);
    }
}
