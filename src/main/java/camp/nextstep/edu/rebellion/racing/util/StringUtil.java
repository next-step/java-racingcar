package camp.nextstep.edu.rebellion.racing.util;

public class StringUtil {
    private static final String EMPTY = "";
    private StringUtil(){}

    public static boolean isEmpty(String str) {
        return null == str || EMPTY.equals(str);
    }
}
