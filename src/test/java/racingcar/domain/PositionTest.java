package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    @Test
    @DisplayName("자동차 위치값이 0보다 클 경우 정상 작동하는지 확인")
    void 자동차_위치값_확인() {
        assertThat(new Position(1).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 위치값이 0보다 작을 경우 에러발생")
    void 자동차_위치값_확인_에러() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(RuntimeException.class);
    }
}

