package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_클론() {
        Car car = new Car();

        car.move();
        Car clone = car.clone();

        assertAll(
            () -> assertThat(clone).isNotSameAs(car),
            () -> assertThat(clone.position()).isEqualTo(car.position())
        );
    }

    @Test
    void 자동차_움직임() {
        Car car = new Car();
        car.move();
        assertThat(car.position()).isEqualTo(Car.SET_POSITION + 1);
    }

    @Test
    void 자동차_초기화() {
        assertThat(new Car().position()).isEqualTo(Car.SET_POSITION);
    }

}
