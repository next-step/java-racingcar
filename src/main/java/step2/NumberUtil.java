package step2;

import java.math.BigDecimal;

public class NumberUtil {

    public static BigDecimal textToBigDecimal(String text) {
        if (!isNumeric(text)) {
            throw new IllegalArgumentException();
        }
        return new BigDecimal(text);
    }


    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
