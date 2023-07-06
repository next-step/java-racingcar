package woowacamp.racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @ValueSource(ints = {0, 3, 999})
    @ParameterizedTest
    void 위치는_0이상이어야_한다(int value) {
        Position position = new Position(value);

        assertThat(position.getValue()).isEqualTo(value);
    }

    @Test
    void 전진한다() {
        Position position = new Position();

        assertThat(position.forward()).isEqualTo(new Position(1));
    }

    @Test
    void 위치가_음수면_예외가_발생한다() {
        int position = -1;

        assertThatThrownBy(() -> new Position(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 움직이면_위치가_변한다() {
        Position position = new Position();

        Position next = position.move(3);

        assertThat(next).isEqualTo(new Position(3));
    }

    @Test
    void 후진을_하면_예외가_발생한다() {
        Position position = new Position(10);

        assertThatThrownBy(() -> position.move(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
