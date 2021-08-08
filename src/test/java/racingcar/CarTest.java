package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void getMove() {
        Car car = new Car("myCar");

        assertThat(car.getRandomNum(Car.FORWARD_RANGE)).isBetween(0,Car.FORWARD_RANGE);
    }

    @Test
    public void moveCar() {
        Car car = new Car("myCar");
        int moveCount = car.getRandomNum(Car.FORWARD_RANGE);

        car.moveCar(moveCount);
        if (moveCount >= Car.MIN_LOCATION) {
            assertThat(car.getCurrentLocation()).isNotEqualTo(0)
                                                .isBetween(0, Car.FORWARD_RANGE);
        }else {
            assertThat(car.getCurrentLocation()).isEqualTo(0);
        }

    }

}
