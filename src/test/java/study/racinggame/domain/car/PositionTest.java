package study.racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void shouldCreateWithSameValue() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    @DisplayName("포지션 값을 증가시킨다")
    void shouldIncreaseValue() {
        Position position = new Position(4);
        assertThat(position.increase()).isEqualTo(new Position(5));
    }

    @Test
    @DisplayName("포지션 값이 최대값과 같으면 true를 반환한다")
    void shouldReturnTrueWhenIsEqualsToMax() {
        int max = 5;
        Position position = new Position(max);

        assertThat(position.maximum(max)).isTrue();
    }
}