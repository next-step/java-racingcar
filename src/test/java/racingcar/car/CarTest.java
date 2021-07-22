package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("이동 조건을 충족하면 자동차는 이동한다.")
    @Test
    void move() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("이동 조건을 충족하지 않으면 자동차는 이동하지 않는다.")
    @Test
    void stop() {
        car.move(() -> false);
        assertThat(car.getPosition()).isZero();
    }

}
