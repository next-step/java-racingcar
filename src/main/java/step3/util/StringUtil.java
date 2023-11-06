package step3.util;

import java.util.List;

public class StringUtil {

    private static final String DELIMITER = ",";

    public static String[] splited(String text) {
        return text.split(DELIMITER);
    }

    public static String combined(List<String> texts) {
        return String.join(DELIMITER, texts);
    }

}
