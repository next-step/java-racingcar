package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    public void 자동차_전진() {
        assertThat(car.go()).isNotBlank().isEqualTo("-");
    }

    @Test
    public void 자동차_정지() {
        assertThat(car.stop()).isBlank().isEqualTo("");
    }
}
