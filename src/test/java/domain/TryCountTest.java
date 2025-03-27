package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {

    @DisplayName("getNumberOfTrial 테스트")
    @Test
    void getNumberOfTrial() {
        int expected = 3;
        TryCount tryCount = new TryCount(expected);
        Assertions.assertThat(tryCount.getNumberOfTrial()).isEqualTo(expected);
    }

    @DisplayName("1보다 작은 숫자를 입력 받았을 경우 IllegalArgumentException")
    @Test
    void illegalArgumentExceptionTest() {
        Assertions.assertThatThrownBy(() -> new TryCount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}