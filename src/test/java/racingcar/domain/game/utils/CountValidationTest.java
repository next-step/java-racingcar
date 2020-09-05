package racingcar.domain.game.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static racingcar.domain.game.utils.CountValidation.checkNumber;
import static racingcar.domain.game.utils.Constants.*;

public class CountValidationTest {

    @Test
    void validNumberTest() {
        assertThat(checkNumber(1)).isEqualTo(1);
    }

    @Test
    void inValidNumberTest() {
        assertThatThrownBy(() -> checkNumber(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(0 + ERROR_ZERO_OR_NEGATIVE);

        assertThatThrownBy(() -> checkNumber(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(-1 + ERROR_ZERO_OR_NEGATIVE);
    }
}