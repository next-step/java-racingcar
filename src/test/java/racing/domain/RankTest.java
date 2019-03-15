package racing.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void 자동차정렬() {
        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 3);

        List<Car> cars = Arrays.asList(car1, car2, car3);

        RacingCarRank racingCarRank = new RacingCarRank();

        racingCarRank.sortCars(cars);

        assertThat(cars).containsExactly(car1, car3, car2);
    }

    @Test
    public void 자동차랭킹() {
        List<Car> cars = Arrays.asList(new Car("car1", 5), new Car("car2", 1), new Car("car3", 3));

        RacingCarRank racingCarRank = new RacingCarRank();

        List<Car> winners = racingCarRank.rankCars(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("car1");
    }

    @Test
    public void 자동차동점자랭킹() {
        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 5);

        List<Car> cars = Arrays.asList(car1, car2, car3);

        RacingCarRank racingCarRank = new RacingCarRank();

        List<Car> winners = racingCarRank.rankCars(cars);

        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactly(car1, car3);
    }
}