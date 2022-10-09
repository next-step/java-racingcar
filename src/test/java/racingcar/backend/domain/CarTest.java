package racingcar.backend.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new CarName("익명"), new Position(0));
    }

    @Test
    @DisplayName("자동차 전진")
    void car_move_test() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 멈춤")
    void car_not_move_test() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
