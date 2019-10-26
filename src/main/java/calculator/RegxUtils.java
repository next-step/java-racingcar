package calculator;

import java.util.regex.Pattern;

/**
 * @author : 김윤호
 * @version :
 * @date : 2019-10-26 01:38
 */
public class RegxUtils {
    private static final Pattern NUMERIC = Pattern.compile("[-+]?\\d*\\.?\\d+");
    private static final Pattern OPERATOR = Pattern.compile("^(\\+|\\-|\\*|\\/)$");

    public static boolean isNumeric(String str) {
        return str != null && NUMERIC.matcher(str).matches();
    }

    public static boolean isOperator(String op) {
        return op != null && OPERATOR.matcher(op).matches();
    }
}
