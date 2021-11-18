package racingcargamefinal.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void create() {
        String carNames = "pobi,crong,honux";
        Cars cars = new Cars(carNames);

        assertThat(cars).isInstanceOf(Cars.class);
    }

    @Test
    void findWinners() {
        Car pobi = new Car("pobi", 3);
        Car crong = new Car("crong", 1);
        Car honux = new Car("honux", 3);

        List<Car> carList = new ArrayList<>();
        carList.add(pobi);
        carList.add(crong);
        carList.add(honux);

        Cars cars = new Cars(carList);

        assertThat(cars.findWinners()).containsExactly(pobi, honux);
    }

}
