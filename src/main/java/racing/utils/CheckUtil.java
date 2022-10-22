package racing.utils;

import org.apache.commons.lang3.StringUtils;
import racing.msg.SystemMention;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[+-]?[0-9]*$");

    public static boolean isNull(String str) {
        if (StringUtils.isBlank(str)) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String str) {
        Matcher matcher = NUMBER_PATTERN.matcher(str);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean isPositive(String str) {
        return isPositive(Integer.parseInt(str));
    }

    public static boolean isPositive(int number) {
        if (number > 0) {
            return true;
        }
        return false;
    }

    public static boolean checkPositive(String input) {
        if (isNull(input)) {
            SystemMention.NULL_CHECK.printMention();
            return false;
        }
        if (!isNumber(input)) {
            SystemMention.NUMBER_CHECK.printMention();
            return false;
        }
        if (!isPositive(input)) {
            SystemMention.POSITIVE_CHECK.printMention();
            return false;
        }
        return true;
    }

    public static boolean checkStrArray(String[] arr) {
        for (String str : arr) {
            if (isNull(str)) {
                SystemMention.NULL_CHECK.printMention();
                return false;
            }
        }
        return true;
    }

    public static boolean checkStrToArray(String input) {
        if (isNull(input)) {
            SystemMention.NULL_CHECK.printMention();
            return false;
        }
        return checkStrArray(SplitUtil.strToArray(input));
    }
}
