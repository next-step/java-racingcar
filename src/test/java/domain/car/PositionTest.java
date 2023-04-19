package domain.car;

import domain.car.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PositionTest {
    @DisplayName("이동거리가 같은 Distance 비교 시 참을 리턴한다")
    @Test
    void equalsTest() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @DisplayName("음수값은 위치로 허용하지 않는다")
    @Test
    void minusPosition() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Position(-1))
                .withMessageMatching("음수값은 허용되지 않습니다.");
    }

    @DisplayName("position 위치를 증가할 수 있다")
    @Test
    void movePosition() {
        Position position = new Position();
        position.move();
        assertThat(position).isEqualTo(new Position(1));
    }
}
