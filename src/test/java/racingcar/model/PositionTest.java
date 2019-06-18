package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("position 객체 생성 확인")
    @Test
    void createPosition() {
        assertThat(Position.valueOf(4)).isNotNull();
        assertThat(Position.valueOf(4)).isEqualTo(Position.valueOf(4));
    }

    @DisplayName("위치 1 증가")
    @Test
    void increasePosition() {
        Position position = Position.valueOf(4);

        Position incrementPosition = position.incrementExact();

        assertThat(incrementPosition.parseInt()).isEqualTo(5);
    }

    @DisplayName("position 가장 큰값 확인")
    @Test
    void cacheTest() {
        Position.valueOf(1);
        Position.valueOf(4);
        Position.valueOf(9);

        Position max = Position.max();

        assertThat(max.parseInt()).isEqualTo(9);
    }
}
