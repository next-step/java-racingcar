package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    public void createCar() {
        assertThatThrownBy(() -> new Car("longName"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void move() {
        Car car = new Car("aaa");
        car.move(() -> true);

        assertThat(car.getPlace()).isEqualTo(1);
    }

    @Test
    public void stop() {
        Car car = new Car("bbb");
        car.move(() -> false);

        assertThat(car.getPlace()).isEqualTo(0);
    }


}