package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("4 이상의 숫자가 주어지면 자동차는 이동한다.")
    @Test
    void move() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("4 미만의 숫자가 주어지면 자동차는 이동하지 않는다.")
    @Test
    void stop() {
        car.move(3);
        assertThat(car.getPosition()).isZero();
    }

}
