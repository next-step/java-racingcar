package racing.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {

    private List<Car> cars;

    @Test
    public void 자동차정렬() {
        cars = new ArrayList<>();

        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 3);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingCarRank racingCarRank = new RacingCarRank();

        racingCarRank.sortCars(cars);

        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car3");
        assertThat(cars.get(2).getName()).isEqualTo("car2");
    }

    @Test
    public void 자동차랭킹() {
        cars = new ArrayList<>();

        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 3);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingCarRank racingCarRank = new RacingCarRank();

        List<Car> winners = racingCarRank.rankCars(cars);

        assertThat(winners.get(0).getName()).isEqualTo("car1");
        assertThat(winners.size()).isEqualTo(1);
    }

    @Test
    public void 자동차동점자랭킹() {
        cars = new ArrayList<>();

        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 5);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingCarRank racingCarRank = new RacingCarRank();

        List<Car> winners = racingCarRank.rankCars(cars);

        assertThat(winners.size()).isEqualTo(2);
    }
}