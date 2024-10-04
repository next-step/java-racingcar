package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {
    @DisplayName("차의 초기 이동 상태는 0이다.")
    @Test
    void car_init_moveStatus_is_zero() {
        CarPosition carPosition = new CarPosition();

        assertThat(carPosition).isEqualTo(new CarPosition(0));
    }

    @DisplayName("차가 전진해 이동 상태가 1 더해진다.")
    @Test
    void increase_value_when_car_moves() {
        CarPosition carPosition = new CarPosition();

        assertThat(carPosition.increase()).isEqualTo(new CarPosition(1));
    }
}