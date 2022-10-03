package racingcar.backend.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final int INITIAL_POSITION = 0;
    private Car car;

    @BeforeEach
    private void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차 전진")
    void car_move_test() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION + 1);
    }

    @Test
    @DisplayName("자동차 멈춤")
    void car_not_move_test() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION);
    }
}
