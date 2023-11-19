package calculator.validator;

import calculator.util.StringUtils;
import error.CustomError;

public class StringValidator {
    public static void validateForBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(CustomError.EMPTY_INPUT_ERROR.getErrorContent());
        }
    }
}
