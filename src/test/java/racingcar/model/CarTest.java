package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 자동차_움직인다() {
        Car car = new Car(0, 1);
        car.tryToMove(5);
        assertThat(car.getMoveDistanceTrace().get(0)).isEqualTo(1);
    }

    @Test
    void 자동차_움직이지_않는다() {
        Car car = new Car(0, 1);
        car.tryToMove(3);
        assertThat(car.getMoveDistanceTrace().get(0)).isZero();
    }

    @Test
    void 자동차_움직인_거리를_추적한다() {
        Car car = new Car(0, 3);
        car.tryToMove(6);
        car.tryToMove(3);
        car.tryToMove(8);
        car.tryToMove(4);
        car.tryToMove(0);
        assertThat(car.getMoveDistanceTrace()).containsExactly(1, 1, 2, 3, 3);
    }
}