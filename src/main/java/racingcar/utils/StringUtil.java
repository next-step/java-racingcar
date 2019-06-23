package racingcar.utils;

import java.util.Collections;

public class StringUtil {
    public static String[] splitBySeparator(String separator, String str){
        return str.trim().split("\\s*" + separator + "\\s*");
    }

    public static String repeat(String s, int count) {
        return String.join("", Collections.nCopies(count, s));
    }
}
