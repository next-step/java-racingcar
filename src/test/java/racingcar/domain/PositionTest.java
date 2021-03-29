package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    @DisplayName("생성자 테스트")
    void create() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
        assertThat(new Position()).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("생성자 예외 테스트")
    void validate() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("위치 이동 테스트")
    void increase() {
        assertThat(new Position(1).increase()).isEqualTo(new Position(2));
    }
}
