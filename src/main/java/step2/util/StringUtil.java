package step2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil
{
    private StringUtil()
    {
        throw new IllegalStateException("Utility class");
    }
    public static boolean isNullOrEmpty(String str)
    {
        return str == null || str.length() == 0;
    }

    public static String[] split(String str, String delimiter)
    {
        return str.split(delimiter);
    }
}
