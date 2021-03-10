package stringcalculator;

import org.apache.commons.lang3.StringUtils;

import static stringcalculator.Message.INPUT_BLANK;
import static stringcalculator.Message.INPUT_NULL;

public class StringCalculator {

    private static final String DELIMITER = " ";

    public static int calculate(String input) {
        validate(input);
        String[] inputArray = split(input);
    }

    public static void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NULL);
        }
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INPUT_BLANK);
        }
    }

    public static String[] split(String input) {
        return input.split(DELIMITER);
    }

}
