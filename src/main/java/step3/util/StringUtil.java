package step3.util;

public class StringUtil {

    private static final String DELIMITER = ",";

    public static String[] splited(String text) {
        return text.split(DELIMITER);
    }

}
