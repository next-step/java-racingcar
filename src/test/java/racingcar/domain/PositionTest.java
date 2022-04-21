package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("음수으로 포지션 생성시 RuntimeException 에러가 발생한다.")
    void positive() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("up을 하면 position 이 1 증가한다.")
    void up() {
        Position position = new Position(0);
        position.up();

        assertThat(position).isEqualTo(new Position(1));
    }
}