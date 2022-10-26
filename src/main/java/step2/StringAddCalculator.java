package step2;

public class StringAddCalculator {

    private static String DELIMETER_COMMA = ",";
    private static String DELIMETER_COLON = ":";
    private static String SPLIT_OR = "|";
    private static String stringProvided = null;
    private static String delimeter = DELIMETER_COMMA + SPLIT_OR + DELIMETER_COLON;

    public static int splitAndSum(String string) {
        stringProvided = string;
        if (nullOrEmpty()) return 0;
        processInCaseCustomDelimeter();
        String[] stringArray = stringProvided.split(delimeter);
        int[] intArray = intArrayFromStringArray(stringArray);
        return intArraySum(intArray);
    }

    private static void processInCaseCustomDelimeter() {
        if (includingCustomDelimeter(stringProvided) == false) return;
        delimeter += SPLIT_OR + customDelimeter(stringProvided);
        stringProvided = stringProvided.substring(4);
    }

    private static int intArraySum(int[] intArray) {
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) sum += intArray[i];
        return sum;
    }

    private static int[] intArrayFromStringArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) intArray[i] = intFromString(stringArray[i]);
        return intArray;
    }

    private static int intFromString(String string) {
        int result = Integer.parseInt(string);
        if (positive(result) == false) throw new RuntimeException();
        return result;
    }

    private static String customDelimeter(String string) {
        return String.valueOf(string.charAt(2));
    }

    private static boolean includingCustomDelimeter(String string) {
        System.out.print(string.length());
        if (string.length() < 4) return false;
        String substring = string.substring(0,4);
        if (substring.startsWith("//") && substring.endsWith("\n")) return true;
        return false;
    }

    private static boolean nullOrEmpty() {
        if (stringProvided == null || stringProvided.equals("")) return true;
        return false;
    }

    private static boolean positive(int integer) {
        if (integer >= 0) return true;
        return false;
    }

}
