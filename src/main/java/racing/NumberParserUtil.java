package racing;

import java.util.Random;

public class NumberParserUtil {

    public static int toInt(String strNumber) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(strNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("Missmatch integer type");
        }
        return parseInt;
    }

}
