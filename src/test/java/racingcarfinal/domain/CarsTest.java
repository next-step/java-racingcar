package racingcarfinal.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private final String names = "pobi,crong,honux";
    private final Cars cars = new Cars(names);

    @Test
    void create() {
        Cars cars = new Cars(names);
        assertThat(cars).isInstanceOf(Cars.class);
    }

    @Test
    void findWinners() {
        Car pobi = new Car("pobi", 1);
        Car crong = new Car("crong", 0);

        List<Car> cars = new ArrayList<>();
        cars.add(pobi);
        cars.add(crong);

        List<Car> winners = Cars.findWinners(cars);
        assertThat(winners).containsExactly(pobi);
    }

}
