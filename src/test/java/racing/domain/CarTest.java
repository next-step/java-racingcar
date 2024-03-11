package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 앞으로_전진() {
        Car car = new Car();
        car.forward(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    void 정지() {
        Car car = new Car();
        car.forward(() -> false);
        assertThat(car.getPosition()).isZero();
    }

}