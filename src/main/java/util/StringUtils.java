package util;

import java.util.Arrays;

public class StringUtils {

    public static boolean isBlank(String param) {

        if (param == null || param.length() == 0) {
            return true;
        }

        return Arrays.stream(param.split(""))
                .allMatch(ch -> ch.equals(" "));
    }
}
