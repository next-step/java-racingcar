package util;

import java.util.regex.Pattern;

public class NumberUtil {
    private static final Pattern POSITIVE_NUMBER_PATTERN = Pattern.compile("[0-9]+");

    private NumberUtil() {}

    public static int getPositiveInteger(String strNum) {
        if (isPositiveNumber(strNum)) {
            return Integer.parseUnsignedInt(strNum);
        }
        throw new RuntimeException("0 이상의 숫자만 입력해주세요.");
    }

    public static boolean isPositiveNumber(String strNum) {
        if (strNum == null) {
            return false;
        }
        return POSITIVE_NUMBER_PATTERN.matcher(strNum).matches();
    }


}
