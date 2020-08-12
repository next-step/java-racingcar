package pobiRacingCar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pobiRacingCar.utils.ValidationUtils.*;
public class ValidationUtilsTest {
    @Test
    void valid_name() {
        assertThat(validName("pobi")).isTrue();

    }
}
