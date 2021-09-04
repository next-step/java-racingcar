package test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    void 이동() {
        Car car = new Car(0);
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 정지() {
        Car car = new Car(0);
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}