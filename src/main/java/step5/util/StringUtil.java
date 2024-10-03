package step5.util;

import java.util.Arrays;

public class StringUtil {

    private final static String COMMA = ",";

    public static String[] deviceComma(String str) {
        return Arrays.stream(str.split(COMMA))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
