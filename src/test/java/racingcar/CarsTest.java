package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차 이름들이 입력되면 입력한 만큼의 자동차 객체를 생성한다.")
    @Test
    void createCarsTest() {
        // given
        String[] carNames = {"pobi","crong","honux"};

        // when
        Cars cars = Cars.createCars(carNames);

        // then
        assertThat(cars.getCars().size()).isEqualTo(carNames.length);
    }

    @DisplayName("가장 많이 움직인 자동차의 이동 횟수를 구할 수 있다.")
    @Test
    void getMaxLocationTest() {
        // given
        Car car1 = Car.createCar("pobi", 3);
        Car car2 = Car.createCar("crong", 5);
        Car car3 = Car.createCar("honux", 2);
        Cars cars = Cars.of(List.of(car1, car2, car3));

        // when
        int maxLocation = cars.getMaxLocation();

        // then
        assertThat(maxLocation).isEqualTo(5);
    }


    @DisplayName("자동차 경주의 우승자를 알아 낼 수 있다.")
    @Test
    void getWinnersTest() {
        // given
        Car car1 = Car.createCar("pobi", 3);
        Car car2 = Car.createCar("crong", 5);
        Car car3 = Car.createCar("honux", 5);
        Cars cars = Cars.of(List.of(car1, car2, car3));

        // when
        List<String> winners = cars.getWinners();

        // then
        assertThat(winners).containsExactlyInAnyOrder("crong", "honux");
    }

}