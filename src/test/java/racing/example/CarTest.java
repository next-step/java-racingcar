package racing.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 이동() {
        Car car = new Car("ocean");
        assertThat(car.move(4)).isEqualTo(new Position(1));
    }

    @Test
    void 정지() {
        Car car = new Car("ocean");
        assertThat(car.move(3)).isEqualTo(new Position(0));
    }
}