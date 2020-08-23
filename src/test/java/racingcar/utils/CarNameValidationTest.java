package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.CarNameValidation.*;

public class CarNameValidationTest {

    @Test
    void validCarName() {
        assertThat(isValid(" ")).isEqualTo(false);
        assertThat(isValid("")).isEqualTo(false);
        assertThat(isValid("helloworld")).isEqualTo(false);
        assertThat(isValid("honux")).isEqualTo(true);
    }
}
