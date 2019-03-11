package racing.service;

import org.junit.Before;
import org.junit.Test;
import racing.domain.Car;

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

        car1.move();
        car1.move();
        car1.move();
        car1.move();
        car1.move();

        car2.move();
        car2.move();
        car2.move();
        car2.move();
        car2.move();

        car3.move();
        car3.move();
        car3.move();
        car3.move();
        car3.move();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    @Test
    public void 자동차정렬() {
        RacingCarRank.sortCars(cars);

        assertThat(cars.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(1).getTotalDistance());
        assertThat(cars.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(2).getTotalDistance());
        assertThat(cars.get(1).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(2).getTotalDistance());
    }

    @Test
    public void 자동차랭킹() {
        RacingCarRank.sortCars(cars);

        List<Car> winners = RacingCarRank.rankCars(cars);

        assertThat(winners.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(0).getTotalDistance());
        assertThat(winners.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(1).getTotalDistance());
        assertThat(winners.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(2).getTotalDistance());
    }
}