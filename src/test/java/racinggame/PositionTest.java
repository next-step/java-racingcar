package racinggame;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.car.Position;

import static org.assertj.core.api.Assertions.assertThat;


class PositionTest {

    @Test
    @DisplayName("[성공] 객체를 생성했을 때 값은 0이다.")
     void of() {
        // when
        final var position = Position.of();

        // then
        assertThat(position.value()).isEqualTo(0);
    }

    @Test
    @DisplayName("[성공] 전진했을 때 값은 1이다.")
    void forward() {
        // given
        final var position = Position.of();

        // when
        final var forwarded = position.forward();

        // then
        assertThat(forwarded.value()).isEqualTo(1);
    }

}
