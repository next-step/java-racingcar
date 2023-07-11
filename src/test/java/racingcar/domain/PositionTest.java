package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    void Position생성할때_성공() {
        // given
        final int input = 5;

        // when
        final Position position1 = Position.from(input);
        final Position position2 = Position.from(0);

        // then
        assertThat(position1.getValue()).isEqualTo(input);
        assertThat(position2.getValue()).isZero();
    }

    @Test
    void 음수로생성할때_실패_RuntimeException발생() {
        // given
        final int input = -1;

        // when & then
        assertThatThrownBy(() -> Position.from(input)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 같은포지션을가질때_같은객체로판단성공() {
        // given
        final int input = 5;
        final Position position1 = Position.from(input);
        final Position position2 = Position.from(input);

        // when & then
        assertThat(position1).isEqualTo(position2);
    }

    @Test
    void 다른포지션을가질때_다른객체로판단성공() {
        // given
        final int input1 = 3;
        final int input2 = 5;
        final Position position1 = Position.from(input1);
        final Position position2 = Position.from(input2);

        // when & then
        assertThat(position1).isNotEqualTo(position2);
    }
}
