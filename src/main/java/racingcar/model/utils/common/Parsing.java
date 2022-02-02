package racingcar.model.utils.common;

import static racingcar.model.utils.common.Validation.validateDuplicateCar;
import static racingcar.model.utils.common.Validation.validateLengthLimit;
import static racingcar.model.utils.common.Validation.validateNumberRange;

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
}
