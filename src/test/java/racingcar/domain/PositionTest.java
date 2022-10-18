package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void compare_position() {
        assertThat(new Position(2).comparePosition(3))
                .isEqualTo(new Position(3).getPosition());
    }
}
