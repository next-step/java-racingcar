package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingCarsTest {

    @Test
    @DisplayName("여러개의 Car 중 Position값이 가장 높은 객체의 int값을 찾는다.")
    public void findMaxPosition() {
        Car car1 = new Car("bus", 5);
        Car car2 = new Car("car", 4);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        RacingCars racingCars = new RacingCars(carList);
        assertThat(racingCars.findMaxPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("여러대의 Car 중 Position값이 가장 큰 객체들을 반환한다.")
    public void findWinners() {
        Car car1 = new Car("bus",3);
        Car car2 = new Car("car",4);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        RacingCars racingCars = new RacingCars(carList);
        List<Car> winners = racingCars.findWinners();
        assertThat(winners.size()).isEqualTo(1);

        for (Car car : winners) {
            assertThat(car).isEqualTo(car2);
        }
    }
}
