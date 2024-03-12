package step2;

import java.util.Scanner;

public class StringSumCalculator {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("String Sum Calculator");
        System.out.println("Basic Delimiters are \",\" and \";\"");
        System.out.println("Enter \"//\" and \"\\n\" followed by your custom delimiter, if wanted (ex. \"//;\\n1;2;3\")");
        System.out.println("Enter the String below (ex. \"1,2,3\")");
        String input = scan.nextLine();
        int result = calculateStringWithSumOnly(input);
        System.out.println("result : " + result);
    }

    public static int calculateStringWithSumOnly(String input){
        emptyReturnZeroString(input);

        if(hasCustomDelimiter(input)){
            String customDelimiter = getCustomDelimiter(input);
            String stringExpression = getStringWithoutCustomDelimiter(input);
            String[] stringArray = splitValuesByCustomDelimiter(customDelimiter, stringExpression);
            return sum(stringArray);
        }
        String[] stringArray = splitWithCommaAndColon(input);
        return sum(stringArray);
    }


    public static String[] splitWithCommaAndColon(String value) {
        return value.split("[,|:]");
    }

    public static String emptyReturnZeroString(String value) {
        if(value.isEmpty()){
            return "0";
        }
        return value;
    }

    public static int sum(String[] valueArray) {
        int result = 0;
        for (String value : valueArray) {
            result += Integer.parseInt(value);
        }
        return result;
    }

    public static String getCustomDelimiter(String value) {
        int start = value.indexOf("//") + 2;
        int end = value.indexOf("\\n", start);
        return value.substring(start, end);
    }

    public static void checkInputAvailable(String value) {
        if (!value.matches("\\d+")) {
            throw new RuntimeException();
        }
    }

    public static Boolean hasCustomDelimiter(String value) {
        if(Character.isDigit(value.charAt(0)))
            return Boolean.FALSE;
        return Boolean.TRUE;
    }

    public static String getStringWithoutCustomDelimiter(String value) {
        return value.substring(5);
    }

    public static String[] splitValuesByCustomDelimiter(String delimiter,
                                                        String value) {
        return value.split(delimiter);
    }
}
