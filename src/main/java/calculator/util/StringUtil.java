package calculator.util;

import calculator.exception.ErrorMessage;

public class StringUtil {

    public static boolean isEmpty(final String str) {
        return (str == null || "".equals(str));
    }

    public static int toInt(final String value) {
        if (isEmpty(value)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SUPPORTED_FORMAT);
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(ErrorMessage.NOT_SUPPORTED_FORMAT);
        }
    }
}
