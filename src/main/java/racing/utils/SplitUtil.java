package racing.utils;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class SplitUtil {

    private static final String SEPARATOR = ",";

    public static String listToStr(List<String> list) {
        StringJoiner sj = new StringJoiner(SEPARATOR);
        for (String info : list) {
            sj.add(info);
        }
        return sj.toString();
    }

    public static List<String> strToList(String str) {
        return Arrays.asList(str.split(SEPARATOR));
    }

    public static String[] strToArray(String str) {
        return str.split(SEPARATOR);
    }
}
