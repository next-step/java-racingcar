package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;

    @Test
    @DisplayName("입력한 수 만큼의 자동차를 생성한다.")
    void 자동차_생성() {
        cars = Cars.fromCarNames(Arrays.asList("name", "name2", "name3"));
        assertThat(cars.getCarList()).hasSize(3);
    }

    @Test
    @DisplayName("자동차 중 1명 이상의 우승자를 구한다.")
    void 우승자_구하기() {
        List<Car> carList = new ArrayList<>();
        Car car = new Car("name1", 3);
        Car car2 = new Car("name2", 8);
        Car car3 = new Car("name3", 8);
        carList.add(car);
        carList.add(car2);
        carList.add(car3);

        cars = new Cars(carList);

        assertThat(cars.getWinners()).hasSize(2);
        assertThat(cars.getWinners()).containsAll(Arrays.asList("name2", "name3"));
    }
}
