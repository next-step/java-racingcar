package racingGame;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    @DisplayName("start() 로 생성한 Position 은 0이다")
    void start_isZero() {
        Position position = Position.start();

        assertThat(position.value()).isEqualTo(0);
    }

    @Test
    @DisplayName("move() 를 호출하면 1 증가한 새로운 Position 이 생성된다")
    void move_createsNewIncrementedPosition() {
        Position position = Position.start();

        Position moved = position.move();

        assertThat(position.value()).isEqualTo(0);
        assertThat(moved.value()).isEqualTo(1);
    }

    @Test
    @DisplayName("isSame 과 isGreaterThan 으로 위치 비교를 수행할 수 있다")
    void comparePositions() {
        Position position = Position.start().move().move();

        assertThat(position.isSame(2)).isTrue();
        assertThat(position.isGreaterThan(1)).isTrue();
        assertThat(position.isGreaterThan(3)).isFalse();
    }
}
