package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("가장 멀리 간 자동차가 우승자인지 확인")
    void findWinners() {
        Car testCar1 = new Car(new CarName("yun"), new CarPosition(0));
        Car testCar2 = new Car(new CarName("yun2"), new CarPosition(3));
        List<Car> carList = Arrays.asList(testCar1, testCar2);
        Cars cars = new Cars(carList);

        List<Car> winners = cars.findWinners();
        assertThat(winners).containsExactly(testCar2);
    }

}
