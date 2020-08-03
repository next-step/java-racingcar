package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = Car.createCar();
    }

    @Test
    void createCarTest() {
        assertThat(this.car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void moveStopTest(int fuel) {
        int prev = this.car.getPosition();
        this.car.move(fuel);
        int next = this.car.getPosition();

        assertThat(prev).isEqualTo(next);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void moveForwardTest(int fuel) {
        int prev = this.car.getPosition();
        this.car.move(fuel);
        int next = this.car.getPosition();

        assertThat(prev).isLessThan(next);
    }
}