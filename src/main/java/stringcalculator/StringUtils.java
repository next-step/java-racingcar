package stringcalculator;

public class StringUtils {
    private static final String DELIMITER = " ";

    public static String[] split(String s) {
        return s.split(DELIMITER);
    }
}
