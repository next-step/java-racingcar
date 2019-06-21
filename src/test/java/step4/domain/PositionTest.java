package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositionTest {
    private static final int NEGATIVE_NUMBER = -1;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private Position position = new Position();

    @Test
    void 기본_위치는_0이다() {
        assertThat(position).isEqualTo(ZERO);
    }

    @Test
    void 위치가_음수면_예외를_발생시킨다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Position(NEGATIVE_NUMBER);
                }).withMessageContaining("위치값은 음수가 될 수 없습니다.");
    }

    @Test
    void 전진하면_position이_1만큼_증가한다() {
        Position movedPosition = position.move(Position.INITIAL_POSITION);

        assertThat(movedPosition.getPosition()).isEqualTo(ONE);
    }
}