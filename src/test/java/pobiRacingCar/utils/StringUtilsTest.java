package pobiRacingCar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    void repeat() {
        assertThat(StringUtils.repeat("-", 5)).isEqualTo("-----");
        assertThat(StringUtils.repeat("-", 3)).isEqualTo("---");
    }
}
