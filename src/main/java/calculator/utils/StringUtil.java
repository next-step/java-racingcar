package calculator.utils;

public class StringUtil {

    private StringUtil() { }

    private static final String STR_EMPTY = " ";

    public static String[] splitString(String str) {
        return str.split(STR_EMPTY);
    }

}
