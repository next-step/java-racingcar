package racing.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {

    private List<Car> cars;

    @Before
    public void 자동차경주초기화() {
        cars = new ArrayList<>();

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        for (int i = 0; i < 5; i++) {
            car1.move();
            car2.move();
            car3.move();
        }

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    @Test
    public void 자동차정렬() {
        RacingCarRank racingCarRank = new RacingCarRank();

        racingCarRank.sortCars(cars);

        assertThat(cars.get(0).compareTo(cars.get(1))).isGreaterThanOrEqualTo(0);
        assertThat(cars.get(0).compareTo(cars.get(2))).isGreaterThanOrEqualTo(0);
        assertThat(cars.get(1).compareTo(cars.get(2))).isGreaterThanOrEqualTo(0);

        assertThat(cars.get(2).compareTo(cars.get(1))).isLessThanOrEqualTo(0);
        assertThat(cars.get(2).compareTo(cars.get(0))).isLessThanOrEqualTo(0);
        assertThat(cars.get(1).compareTo(cars.get(0))).isLessThanOrEqualTo(0);
    }

    @Test
    public void 자동차랭킹() {
        RacingCarRank racingCarRank = new RacingCarRank();

        List<Car> winners = racingCarRank.rankCars(cars);

        assertThat(winners.get(0).compareTo(cars.get(0))).isGreaterThanOrEqualTo(0);
        assertThat(winners.get(0).compareTo(cars.get(1))).isGreaterThanOrEqualTo(0);
        assertThat(winners.get(0).compareTo(cars.get(2))).isGreaterThanOrEqualTo(0);

        assertThat(cars.get(2).compareTo(cars.get(0))).isLessThanOrEqualTo(0);
        assertThat(cars.get(1).compareTo(cars.get(0))).isLessThanOrEqualTo(0);
    }
}