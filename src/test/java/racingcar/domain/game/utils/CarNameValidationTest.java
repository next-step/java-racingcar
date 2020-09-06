package racingcar.domain.game.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static racingcar.domain.game.utils.CarNameValidation.*;
import static racingcar.domain.game.utils.Constants.*;

public class CarNameValidationTest {

    @Test
    void validCarNameTest() {
        assertThat(checkName("honux")).isEqualTo("honux");
    }

    @Test
    void inValidCarNameTest() {
        assertThatThrownBy(() -> checkName(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("" + ERROR_NULL_OR_BLANK);

        assertThatThrownBy(() -> checkName("   "))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("" + ERROR_NULL_OR_BLANK);

        assertThatThrownBy(() -> checkName("helloWorld"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("" + ERROR_NAME_LENGTH_OVER);
    }
}
