package car;

import domain.car.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @DisplayName("이동거리가 같은 Distance 비교 시 참을 리턴한다")
    @Test
    void equalsTest() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }
}
