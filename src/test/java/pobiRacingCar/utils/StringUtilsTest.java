package pobiRacingCar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    void repeat() {
        String result = StringUtils.repeat("-", 5);
        assertThat(result).isEqualTo("-----");
    }
}
