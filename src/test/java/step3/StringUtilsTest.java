package step3;

import CarRacing.StringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilsTest {
    @Test
    void makeGaugeTest() {
        assertThat(StringUtils.makeGauge(4)).isEqualTo("----\n");
    }

    @Test
    void checkEmptyStringError() {
        assertThatThrownBy(() -> {
            StringUtils.splitStringToStringArr(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
