package racingcar;

import org.junit.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 이동테스트() {
        Car car = new Car(1);
        car.move();
        assertThat(car.getPosition()).isBetween(1,11);
    }
}
