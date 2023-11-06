package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차는 전진 또는 정지할 수 있다.")
    @Test
    void car_move_or_stop_sucess() {
        // given
        Car car = new Car();
        assertThat(car.getPosition()).isZero();

        // when
        car.move(0);
        assertThat(car.getPosition()).isZero();


        car.move(1);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
