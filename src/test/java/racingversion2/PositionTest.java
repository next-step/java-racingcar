package racingversion2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingversion2.car.Position;

class PositionTest {

    @Test
    @DisplayName("Position 의 최초 생성값은 0")
    void defaultPosition() {
        Position position = new Position();
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Position 값을 1 증가시키기")
    void increasePosition() {
        Position position = new Position();
        position.increase();
        assertThat(position.getPosition()).isEqualTo(1);
    }

}