package carracing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @DisplayName("차의 초기 이동 상태는 0이다.")
    @Test
    void car_init_moveStatus_is_zero() {
        Position position = new Position();

        assertThat(position).isEqualTo(new Position(0));
    }

    @DisplayName("차가 전진해 이동 상태가 1 더해진다.")
    @Test
    void increase_value_when_car_moves() {
        Position position = new Position();

        assertThat(position.increase()).isEqualTo(new Position(1));
    }

    @DisplayName("자신의 value 값과 인자 값을 비교하여 최대값을 반환한다.")
    @Test
    void return_max_position_compare_value_with_argument() {
        Position position = new Position(4);

        assertThat(position.compareMax(3)).isEqualTo(4);
        assertThat(position.compareMax(5)).isEqualTo(5);
    }
    @DisplayName("자신의 value 값과 인자 값을 비교하여 같은 값인지를 비교하여 결과를 반환한다.")
    @Test
    void return_result_compareTo_value_with_argument() {
        Position position = new Position(4);

        assertThat(position.isSame(4)).isTrue();
        assertThat(position.isSame(5)).isFalse();
    }
}