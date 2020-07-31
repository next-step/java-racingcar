package camp.nextstep.edu.rebellion.calc.util;

import java.util.regex.Pattern;

public class NumberUtil {
    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static final String EMPTY = "";

    private NumberUtil(){}

    public static boolean isNumeric(String str) {
        if(isEmpty(str)) {
            return false;
        }
        return pattern.matcher(str).matches();
    }

    private static boolean isEmpty(String str) {
        return null == str || EMPTY.equals(str);
    }
}
