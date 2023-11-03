package step2.utils;

import static step2.utils.StringParseUtils.isNullOrEmpty;
import static step2.utils.StringParseUtils.parseString;

public class CalculatorUtils {

    public static int sumStringValues(String numbers) {
        if (isNullOrEmpty(numbers)) {
            return 0;
        }

        return parseString(numbers).stream().reduce(0, Integer::sum);
    }
}
