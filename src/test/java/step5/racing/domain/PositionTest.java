package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void 자동차의_초기_위치는_0으로_설정된다() {
        assertThat(new Position()).isEqualTo(new Position(0));
    }

    @Test
    void 자동차의_위치는_양수여야_한다() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 위치_이동에_성공한다() {
        Position position = new Position();
        assertThat(position.move()).isEqualTo(new Position(1));
    }
}
