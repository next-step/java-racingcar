package step2.util;

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
}
