package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import util.Number;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void moveCar() {
        Car car = new Car("myCar");
        int randomNum = Number.getRandomNum(Car.FORWARD_RANGE);

        car.moveCar(randomNum);
        if (randomNum >= Car.FORWARD_MIN_NUMBER) {
            assertThat(car.getCurrentLocation()).isNotEqualTo(0)
                                                .isBetween(0, Car.FORWARD_RANGE);
        }else {
            assertThat(car.getCurrentLocation()).isEqualTo(0);
        }

    }

}
