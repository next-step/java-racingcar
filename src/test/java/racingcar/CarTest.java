package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final int FORWARD = 1;
    private static final int STOP = 0;
    private Car car = Car.createCar();

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

        int state = next - prev;

        assertThat(state).isEqualTo(STOP);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void moveForwardTest(int fuel) {
        int prev = this.car.getPosition();
        this.car.move(fuel);
        int next = this.car.getPosition();

        int state = next - prev;

        assertThat(state).isEqualTo(FORWARD);
    }
}