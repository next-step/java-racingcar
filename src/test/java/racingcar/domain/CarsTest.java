package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("선두 자동차는 1개 이상이다")
    @Test
    void getLeaders() {
        List<Car> carList = Arrays.asList(
                new Car("car1", 1),
                new Car("car2", 2),
                new Car("car3", 3),
                new Car("car4", 3)
        );

        Cars cars = new Cars(carList);
        List<String> leaders = cars.getLeaders();

        assertThat(leaders.size()).isEqualTo(2);
    }
}
