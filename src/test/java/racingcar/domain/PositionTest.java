package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @DisplayName("getPosition 테스트")
    @Test
    void getPosition() {
        Position position = new Position(5);
        assertThat(position.getPosition()).isEqualTo(5);
    }

    @DisplayName("포지션 증가")
    @Test
    void increase() {
        Position position = new Position(0);
        Position newPosition = position.increase();

        assertThat(newPosition.getPosition()).isEqualTo(1);

    }
}