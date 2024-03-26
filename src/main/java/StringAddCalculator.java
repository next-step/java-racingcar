import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jeongheekim
 * @date 3/10/24
 */
public class StringAddCalculator {
    private static final Pattern PATTERN = Pattern.compile("\\/\\/(.)\\\\n(.*)");
    public static int splitAndSum(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String seperator = extractSeperator(str);
        String formattedStr = formattingStr(str);
        return sum(split(formattedStr, seperator));
    }

    private static String formattingStr(String str) {
        Matcher m = PATTERN.matcher(str);
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
            if(validationNumber(num)) {
                sum += checkNegative(Integer.parseInt(num));
            }
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
        Matcher m = PATTERN.matcher(str);
        if (m.find()) {
            return  m.group(1);
        }
        String regex = "[\\\\,\\\\:\\\\;]";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        return matcher.find() ? matcher.group(0) : null;
    }
}
