package racingcar.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputUtilsTest {

    @Test
    @DisplayName("자동차 위치 시각화")
    void convertLiteral() {
        assertThat(OutputUtils.convertLiteral(3)).isEqualTo("---");
    }
}