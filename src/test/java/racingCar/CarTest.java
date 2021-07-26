package racingCar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void canMove() {
        assertThat(car.canMove(4)).isTrue();
        assertThat(car.canMove(3)).isFalse();
    }

    @Test
    void 이동() {
        assertThat(car.move(5)).isEqualTo(1);
        assertThat(car.move(4)).isEqualTo(2);
        assertThat(car.move(3)).isEqualTo(2);
    }

    @AfterEach
    void init() {
        car = null;
    }
}