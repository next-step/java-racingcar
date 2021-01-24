package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.util.InputValidator;

class InputValidatorTest {

    @Test
    void validateCarName() {
        assertThat(InputValidator.validateCarName(new String[]{"pobi","woni","jun"})).isEqualTo(true);
        assertThat(InputValidator.validateCarName(new String[]{"pobi","woni","junnnn"})).isEqualTo(false);
    }

    @Test
    void validGameCntInput() {
        assertThat(InputValidator.validGameCntInput("5")).isEqualTo(true);
        assertThat(InputValidator.validGameCntInput("ddd")).isEqualTo(false);
    }
}