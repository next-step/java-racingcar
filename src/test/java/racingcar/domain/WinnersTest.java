package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.Winners.getWinners;

class WinnersTest {

    @Test
    void 우승자_찾기() throws Exception {
        Car car1 = new Car("a", 4);
        Car car2 = new Car("b", 3);
        Car car3 = new Car("c", 2);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car> winners = getWinners(cars);
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0)).isEqualTo(car1);
    }

}
