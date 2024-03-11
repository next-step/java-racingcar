import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jeongheekim
 * @date 3/10/24
 */
public class StringAddCalculator {
    public static int splitAndSum(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = formattingStr(str);
        return sum(split(str, extractSeperator(str)));
    }

    private static String formattingStr(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            str = m.group(2);
        }
        return str;
    }

    private static String[] split(String str, String seperator) {
        if (seperator == null) {
            seperator = "";
        }
        return str.split(seperator);
    }

    private static int sum(String[] split) {
        int sum = 0;
        for (String num : split) {
            sum += checkNegative(Integer.parseInt(validationNumber(num) ? num : "0"));
        }
        return sum;
    }

    private static boolean validationNumber(String num) {
        return num.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private static int checkNegative(int i) {
        if (i < 0) {
            throw new RuntimeException();
        }
        return i;
    }

    private static String extractSeperator(String str) {
        String regex = "[\\\\,\\\\:\\\\;]";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        return matcher.find() ? matcher.group(0) : null;
    }
}
