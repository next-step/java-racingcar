package racing_car.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    
    @Test
    @DisplayName("포지션 증가 확인")
    void increase() {
        assertThat(new Position(1)).isEqualTo(new Position(0).increase());
    }
}