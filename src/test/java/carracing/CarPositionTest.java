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

    @DisplayName("자신의 value 값과 인자 값을 비교하여 최대값을 반환한다.")
    @Test
    void return_max_position_compare_value_with_argument() {
        CarPosition carPosition = new CarPosition(4);

        assertThat(carPosition.getMax(3)).isEqualTo(4);
        assertThat(carPosition.getMax(5)).isEqualTo(5);
    }
    @DisplayName("자신의 value 값과 인자 값을 비교하여 같은 값인지를 비교하여 결과를 반환한다.")
    @Test
    void return_result_compareTo_value_with_argument() {
        CarPosition carPosition = new CarPosition(4);

        assertThat(carPosition.isSame(4)).isTrue();
        assertThat(carPosition.isSame(5)).isFalse();
    }
}