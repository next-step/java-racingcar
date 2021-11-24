package step5.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    public static List<String> toList(String str) {
        final String DELIMITER = ",";
        return Arrays.asList(str.split(DELIMITER));
    }
}
