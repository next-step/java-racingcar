package game.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void 포지션_생성() {
        Assertions.assertThat(new Position()).isEqualTo(new Position(0));
        Assertions.assertThat(new Position(2)).isEqualTo(new Position("2"));
    }

    @Test
    void 포지션_생성_예외() {
        Assertions.assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 포지션_이동() {
        Position position = new Position(0);

        Assertions.assertThat(position.increase()).isEqualTo(new Position(1));
    }

    @Test
    void 최대값_일치() {
        Position position = new Position(5);

        assertThat(position.isMaxPosition(5)).isTrue();
    }

    @Test
    void 최대값_불일치() {
        Position position = new Position(5);

        assertThat(position.isMaxPosition(4)).isFalse();
    }

    @Test
    void 최대값_구하기() {
        Position position = new Position(0);

        assertThat(position.maxPosition(1)).isOne();
    }

}
