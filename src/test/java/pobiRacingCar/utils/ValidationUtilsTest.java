package pobiRacingCar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pobiRacingCar.utils.ValidationUtils.*;
public class ValidationUtilsTest {
    @Test
    void valid_name() {
        assertThat(validName("pobi")).isTrue();
        assertThat(validName("crong")).isTrue();
        assertThat(validName("honux")).isTrue();
    }

    @Test
    void invalid_name_nullOrBlank() {
        assertThat(validName(null)).isFalse();
        assertThat(validName("")).isFalse();
    }

    @Test
    void invalid_name_overBound() {
        assertThat(validName("harrypotter")).isFalse();
    }
}
