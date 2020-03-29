package step3;

import CarRacing.view.RacingView;
import CarRacing.Utils.StringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilsTest {
    @Test
    void makeGaugeTest() {
        assertThat(RacingView.makeGauge(4)).isEqualTo("----\n");
    }

    @Test
    void checkEmptyStringError() {
        assertThatThrownBy(() -> {
            StringUtils.splitStringToStringArr(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
