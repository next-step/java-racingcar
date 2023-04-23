package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName(value = "우승자는 여러명일 수 있다")
    void test1() {
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 2);
        Car car3 = new Car("car3", 2);
        List<Car> carList = Arrays.asList(car1, car2, car3);
        Cars cars = new Cars(carList);
        assertThat(cars.findWinners()).containsExactly(car2, car3);
    }


}