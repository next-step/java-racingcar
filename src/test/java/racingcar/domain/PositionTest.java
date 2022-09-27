package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("객체 생성하여 동등성 확인")
    void create() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("음수 값을 넣었을 때 예외 체크")
    void invalidCreate() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(RuntimeException.class)
            .hasMessageContaining("음수일 수 없습니다");
    }

    @Test
    @DisplayName("포지션 값을 증가시켰을 때 변화값 확인")
    void add() {
        assertThat(new Position(1).add(new Position(2))).isEqualTo(new Position(3));
        assertThat(new Position(1).add(2)).isEqualTo(new Position(3));
    }
}
