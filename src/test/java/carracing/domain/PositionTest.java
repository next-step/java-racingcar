package carracing.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void positionByNegativeTest() {

        // given
        int input = -1;

        // when & given
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Position(input))
            .withMessageMatching("현재 위치는 음수가 될 수 없습니다.");
    }

}