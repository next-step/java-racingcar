package racing.utils;

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
}
