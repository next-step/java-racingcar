package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositionTest {
    @Test
    void 기본_위치는_0이다() {
        Position position = new Position();

        assertThat(position).isEqualTo(Position.ZERO);
    }

    @Test
    void 위치가_음수면_예외를_발생시킨다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Position(Position.ZERO - 1);
                }).withMessageContaining("위치값은 음수가 될 수 없습니다.");
    }

    @Test
    void 전진하면_position이_1만큼_증가한다() {
        Position position = new Position(Position.ZERO);
        Position movedPosition = position.move();

        assertThat(movedPosition.getPosition()).isEqualTo(1);
    }
}