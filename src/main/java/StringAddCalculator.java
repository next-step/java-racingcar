import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if(textIsEmpty(text)) {
            return 0;
        }

        String[] split = split(text);

        return sum(split);
    }

    private static int sum(String[] split) {
        int sum = 0;
        for (String s : split) {
            int n = Integer.parseInt(s);
            isNegative(n);
            sum += n;
        }

        return sum;
    }

    private static void isNegative(int num) {
        if(num < 0) {
            throw new RuntimeException();
        }
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(",|:|"+customDelimiter);
        }
        return text.split(",|:");
    }

    private static boolean textIsEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
