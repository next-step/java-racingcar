package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Caculator {

    private static final String regex = "[,:]";
    private static final String customRegex = "//(.)\n(.*)";

    public static int input(String text) {
        if(isValidate(text))
            return 0;

        int result = customSeparatorSum(text);
        if(result > 0)
            return result;

        return separatorSum(text);
    }

    private static boolean isValidate(String text) {
        return text == null || text.isEmpty();
    }

    private static int separatorSum(String text) {
        int sum = 0;

        String[] tokens = text.split(regex);
        sum = sum(tokens, sum);
        return sum;
    }

    private static Integer customSeparatorSum(String text) {
        int sum = 0;

        Matcher m = Pattern.compile(customRegex).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            sum = sum(tokens, sum);
            return sum;
        }

        return sum;
    }

    private static int sum(String[] tokens, int sum) {
        for (String token : tokens) {
            checkToken(token);
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    private static void checkToken(String s) {
        int value = 0;

        try {
            value = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아니다");
        }
        
        if(value < 0)
            throw new RuntimeException("음수값");
    }
}
