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
            SystemMention.NULL_CHECK.printMention();
            return true;
        }
        return false;
    }

    public static boolean isNumber(String str) {
        Matcher matcher = NUMBER_PATTERN.matcher(str);
        if (matcher.find()) {
            return true;
        }
        SystemMention.NUMBER_CHECK.printMention();
        return false;
    }

    public static boolean isPositive(String str) {
        return isPositive(Integer.parseInt(str));
    }

    public static boolean isPositive(int number) {
        if (number > 0) {
            return true;
        }
        SystemMention.POSITIVE_CHECK.printMention();
        return false;
    }

    public static boolean checkPositive(String input) {
        if (isNull(input)) {
            return false;
        }
        if (!isNumber(input)) {
            return false;
        }
        return isPositive(input);
    }

    public static boolean checkStrArray(String[] arr) {
        for (String str : arr) {
            if (isNull(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkStrToArray(String input) {
        if (isNull(input)) {
            return false;
        }
        return CheckUtil.checkStrArray(SplitUtil.strToArray(input));
    }

    public static boolean checkStrList(List<String> list) {
        for (String str : list) {
            if (isNull(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkStrToList(String input) {
        if (isNull(input)) {
            return false;
        }
        return CheckUtil.checkStrList(SplitUtil.strToList(input));
    }
}
