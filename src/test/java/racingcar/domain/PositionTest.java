package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @ValueSource(ints = {0, 3, 999})
    @ParameterizedTest
    @DisplayName("위치가 0 이상이면 정상적으로 생성한다.")
    void test_01(final int value) {
        /* given */
        final Position position = new Position(value);

        /* when & then */
        assertThat(position.getValue()).isEqualTo(value);
    }

    @Test
    @DisplayName("위치가 음수면 IllegalArgumentException을 던진다.")
    void test_02() {
        /* given */
        final int position = -1;

        /* when & then */
        assertThatThrownBy(() -> new Position(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("특정 위치에서 움직이면 위치가 변한다.")
    void test_03() {
        /* given */
        final Position position = new Position(0);

        /* when */
        final Position next = position.move(3);

        /* then */
        assertThat(next).isEqualTo(new Position(3));
    }

    @Test
    @DisplayName("후진을 하면 IllegalArgumentException을 던진다.")
    void test_04() {
        /* given */
        final Position position = new Position(10);

        /* when & then */
        assertThatThrownBy(() -> position.move(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
