package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("차의 초기 이동 상태는 0이다.")
    @Test
    void car_init_moveStatus_is_zero() {
        Car car = new Car();

        assertThat(car.getMoveStatus()).isZero();
    }
    @DisplayName("기준 값이 4이상 일때에만 차가 전진해 이동 상태가 1 더해진다.")
    @Test
    void move_car_when_reference_is_between_4_and_9() {
        Car car = new Car();

        car.move(4);

        assertThat(car.getMoveStatus()).isEqualTo(1);
    }

    @DisplayName("기준 값이 4 미만 일때에는 차가 전진하지 않는다.")
    @Test
    void do_not_move_car_when_reference_is_lowerThan_4_or_biggerThan_9() {
        Car car = new Car();

        car.move(3);

        assertThat(car.getMoveStatus()).isZero();
    }
}
