package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @DisplayName("음수 포지션 생성시 에러")
    @Test
    void negativePosition() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(-1));
    }
}