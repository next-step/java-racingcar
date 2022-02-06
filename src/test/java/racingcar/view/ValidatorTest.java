package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.common.SystemMessage;
import racingcar.common.exception.InputValidationException;

class ValidatorTest {

    List<String> lengthLimitExceptions = new ArrayList<>(Arrays.asList("aa", "aaaaaaa"));
    List<String> duplicatedExceptions = new ArrayList<>(Arrays.asList("aaa", "aaa"));

    @Test
    void 자동차의_이름은_1글자_이상_5글자_이하여야_한다() {
        assertThatThrownBy(() -> Validator.validateLengthLimit(lengthLimitExceptions))
            .isInstanceOf(InputValidationException.class)
            .hasMessage(SystemMessage.CAR_NAME_LENGTH_LIMIT_ERROR);
    }

    @Test
    void 자동차의_이름은_중복될_수_없다() {
        assertThatThrownBy(() -> Validator.validateDuplicateCar(duplicatedExceptions))
            .isInstanceOf(InputValidationException.class)
            .hasMessage(SystemMessage.CAR_NAME_DUPLICATE_ERROR);
    }

}
