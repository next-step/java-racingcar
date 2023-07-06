package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void carTest_move() {
        Car car = new Car(new CarName("hello"), new MockRandom(4));
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void carTest_not_move() {
        Car car = new Car(new CarName("hello"), new MockRandom(3));
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
