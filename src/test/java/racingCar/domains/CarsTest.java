package racingCar.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @DisplayName("position이 가장 큰 자동차들이 우승자이다")
    @Test
    void findWinners() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("a", 2));
        carList.add(new Car("b"));
        carList.add(new Car("c", 2));

        Cars cars = new Cars(carList);
        assertThat(cars.findWinners()).containsExactlyInAnyOrder(new Car("c", 2), new Car("a", 2));

    }
}
