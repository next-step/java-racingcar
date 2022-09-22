package racing_car.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    
    @Test
    @DisplayName("포지션 증가 확인")
    void increase() {
        Position position = new Position(1);
        Position tmpPosition = new Position(0);
        assertThat(position).isEqualTo(tmpPosition.increase());
    }
}