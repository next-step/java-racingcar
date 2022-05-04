package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.domain.Winners;

import java.util.Arrays;


import static org.assertj.core.api.Assertions.*;

public class WinnersTest {
    @Test
    void 단일우승자() {
        Cars cars = new Cars(Arrays.asList(new Car("crong", 4), new Car("pobi", 3), new Car("honux", 2)));
        Winners winners = new Winners(Arrays.asList(new Car("crong", 4)));

        assertThat(winners).isEqualTo(cars.winnerCars());
    }

    @Test
    void 복수우승자() {
        Cars cars = new Cars(Arrays.asList(new Car("crong", 4), new Car("pobi", 4), new Car("honux", 2)));
        Winners winners = new Winners(Arrays.asList(new Car("crong", 4), new Car("pobi", 4)));

        assertThat(winners).isEqualTo(cars.winnerCars());
    }
}
