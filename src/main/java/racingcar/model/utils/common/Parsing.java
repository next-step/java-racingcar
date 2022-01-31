package racingcar.model.utils.common;

import static racingcar.model.utils.common.Validation.*;
import static racingcar.model.utils.common.Validation.validateLengthLimit;

import racingcar.model.utils.exception.InputValidationException;

public class Parsing {

    public static boolean parsingCarName(final String name) {
        try {
            validateLengthLimit(StringUtils.splitStr(name));
            validateDuplicateCar(StringUtils.splitStr(name));
        } catch (InputValidationException exception) {
            System.out.println(exception.getMessage());
            return true;
        }
        return false;
    }

    public static boolean racingTryCheck(final int count) {
        try {
            validateNumberRange(count);
        } catch (InputValidationException exception) {
            System.out.println(exception.getMessage());
            return true;
        }
        return false;
    }
}
