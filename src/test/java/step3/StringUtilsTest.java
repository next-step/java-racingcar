package step3;

import CarRacing.StringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    void gaugeMakerTest() {
        assertThat(StringUtils.makeGauge(4)).isEqualTo("----\n");
    }
}
