import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text){

        if(checkEmptyOrNull(text)) return 0;

        String[] tokens= stringSplit(text);
        checkNegativeNum(tokens);

        return sum(tokens);
    }

    private static String[] stringSplit(String text){

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private static boolean checkEmptyOrNull(String text){
        return text == null || text.isEmpty();
    }

    private static void checkNegativeNum(String[] text){
        boolean flag = Arrays.stream(text).mapToInt(Integer::parseInt).anyMatch(n -> n < 0);
        if(flag)
            throw new RuntimeException("Negative Number is not allowed");
    }

    private static int sum(String[] tokens){
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }

}
